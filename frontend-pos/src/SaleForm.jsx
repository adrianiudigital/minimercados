import React, { useEffect, useState } from 'react';
import jsPDF from 'jspdf';
import 'jspdf-autotable';

function SaleForm() {
  const [clients, setClients] = useState([]);
  const [products, setProducts] = useState([]);
  const [sales, setSales] = useState([]);
  const [filtro, setFiltro] = useState('');

  const [clientId, setClientId] = useState('');
  const [productId, setProductId] = useState('');
  const [quantity, setQuantity] = useState(1);
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetch('http://localhost:8080/clients')
      .then(res => res.json())
      .then(data => setClients(data));

    fetch('http://localhost:8080/products')
      .then(res => res.json())
      .then(data => setProducts(data));

    fetchSales();
  }, []);

  const fetchSales = () => {
    fetch('http://localhost:8080/sales')
      .then(res => res.json())
      .then(data => setSales(data))
      .catch(() => setMessage('❌ Error al cargar ventas.'));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const parsedClientId = parseInt(clientId);
    const parsedProductId = parseInt(productId);
    const quantityInt = parseInt(quantity);

    const selectedProduct = products.find(p => p.id === parsedProductId);
    if (!selectedProduct) {
      setMessage("❌ Producto no encontrado.");
      return;
    }

    const unitPrice = selectedProduct.price;
    const subtotal = unitPrice * quantityInt;

    const saleRequest = {
      clientId: parsedClientId,
      userId: 1,
      date: new Date().toISOString(),
      total: subtotal,
      details: [
        {
          productId: parsedProductId,
          quantity: quantityInt,
          unitPrice,
          subtotal
        }
      ]
    };

    try {
      const response = await fetch('http://localhost:8080/sales', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(saleRequest),
      });

      if (response.ok) {
        const data = await response.json();
        setMessage(`✅ Venta registrada con ID: ${data.id}`);
        setClientId('');
        setProductId('');
        setQuantity(1);
        fetchSales();
      } else {
        setMessage('❌ Error al registrar la venta.');
      }
    } catch (err) {
      console.error(err);
      setMessage('❌ Error de conexión al servidor.');
    }
  };

  const handleDownloadPDF = () => {
    const doc = new jsPDF();
    doc.setFontSize(16);
    doc.text('Reporte de Ventas', 14, 20);

    const tableColumn = ["ID", "Fecha", "Cliente", "Total", "Items"];
    const tableRows = [];

    sales
      .filter(sale => {
        const clienteNombre = (clients.find(c => c.id === sale.clientId)?.name || '').toLowerCase();
        return clienteNombre.includes(filtro.toLowerCase());
      })
      .forEach(sale => {
        const saleData = [
          sale.id,
          new Date(sale.date).toLocaleDateString(),
          (clients.find(c => c.id === sale.clientId)?.name) || "Sin nombre",
          `$${sale.total?.toFixed(2)}`,
          sale.details?.length || 0,
        ];
        tableRows.push(saleData);
      });

    doc.autoTable({
      head: [tableColumn],
      body: tableRows,
      startY: 30,
    });

    doc.save("reporte_ventas.pdf");
  };

  return (
    <div className="row">
      <div className="col-md-4">
        <h4 className="mb-3">Registrar Venta</h4>
        <form onSubmit={handleSubmit}>
          <div className="mb-2">
            <label className="form-label">Cliente</label>
            <select className="form-select" value={clientId} onChange={(e) => setClientId(e.target.value)} required>
              <option value="">Seleccione un cliente</option>
              {clients.map(c => (
                <option key={c.id} value={c.id}>{c.name}</option>
              ))}
            </select>
          </div>
          <div className="mb-2">
            <label className="form-label">Producto</label>
            <select className="form-select" value={productId} onChange={(e) => setProductId(e.target.value)} required>
              <option value="">Seleccione un producto</option>
              {products.map(p => (
                <option key={p.id} value={p.id}>{p.name} – Stock: {p.stock}</option>
              ))}
            </select>
          </div>
          <div className="mb-2">
            <label className="form-label">Cantidad</label>
            <input type="number" className="form-control" min="1" value={quantity} onChange={(e) => setQuantity(e.target.value)} required />
          </div>
          <button type="submit" className="btn btn-success w-100">Guardar Venta</button>
        </form>
        {message && <div className="alert alert-info mt-3">{message}</div>}
      </div>

      <div className="col-md-8">
        <h4 className="mb-3">Historial de Ventas</h4>
        <input
          type="text"
          className="form-control mb-3"
          placeholder="🔎 Buscar por cliente"
          value={filtro}
          onChange={(e) => setFiltro(e.target.value)}
        />
        <button onClick={handleDownloadPDF} className="btn btn-outline-primary mb-3">
          📄 Descargar PDF
        </button>
        <table className="table table-striped table-bordered">
          <thead className="table-dark">
            <tr>
              <th>ID</th>
              <th>Fecha</th>
              <th>Cliente</th>
              <th>Total</th>
              <th>Items</th>
            </tr>
          </thead>
          <tbody>
            {sales
              .filter(sale => {
                const clienteNombre = (clients.find(c => c.id === sale.clientId)?.name || '').toLowerCase();
                return clienteNombre.includes(filtro.toLowerCase());
              })
              .map(sale => (
                <tr key={sale.id}>
                  <td>{sale.id}</td>
                  <td>{new Date(sale.date).toLocaleDateString()}</td>
                  <td>{(clients.find(c => c.id === sale.clientId)?.name) || "Sin nombre"}</td>
                  <td>${sale.total?.toFixed(2)}</td>
                  <td>{sale.details?.length || 0}</td>
                </tr>
              ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default SaleForm;
