import React, { useEffect, useState } from 'react';

function ProductList() {
  const [products, setProducts] = useState([]);
  const [name, setName] = useState('');
  const [price, setPrice] = useState('');
  const [stock, setStock] = useState('');
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = () => {
    fetch('http://localhost:8080/products')
      .then(res => res.json())
      .then(data => setProducts(data))
      .catch(() => setMessage('❌ Error al cargar productos.'));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const productData = {
      name,
      price: parseFloat(price),
      stock: parseInt(stock),
      categoryId: 1,  // ⚠️ Asignado para evitar errores
      providerId: 1   // ⚠️ Asignado para evitar errores
    };

    try {
      const response = await fetch('http://localhost:8080/products', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(productData),
      });

      if (response.ok) {
        setMessage('✅ Producto creado correctamente');
        setName('');
        setPrice('');
        setStock('');
        fetchProducts();
      } else {
        setMessage('❌ Error al crear producto.');
      }
    } catch (err) {
      console.error(err);
      setMessage('❌ Error de conexión al servidor.');
    }
  };

  return (
    <div className="row">
      {/* Formulario para crear producto */}
      <div className="col-md-4">
        <h4 className="mb-3">Crear Producto</h4>
        <form onSubmit={handleSubmit}>
          <div className="mb-2">
            <label className="form-label">Nombre</label>
            <input type="text" className="form-control" value={name} onChange={(e) => setName(e.target.value)} required />
          </div>
          <div className="mb-2">
            <label className="form-label">Precio</label>
            <input type="number" step="0.01" className="form-control" value={price} onChange={(e) => setPrice(e.target.value)} required />
          </div>
          <div className="mb-2">
            <label className="form-label">Stock</label>
            <input type="number" className="form-control" value={stock} onChange={(e) => setStock(e.target.value)} required />
          </div>
          <button type="submit" className="btn btn-primary w-100">Guardar Producto</button>
        </form>

        {message && <div className="alert alert-info mt-3">{message}</div>}
      </div>

      {/* Tabla de productos */}
      <div className="col-md-8">
        <h4 className="mb-3">Lista de Productos</h4>
        <table className="table table-striped table-bordered">
          <thead className="table-dark">
            <tr>
              <th>Nombre</th>
              <th>Precio</th>
              <th>Stock</th>
            </tr>
          </thead>
          <tbody>
            {products.map(p => (
              <tr key={p.id}>
                <td>{p.name}</td>
                <td>${p.price.toFixed(2)}</td>
                <td>{p.stock}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ProductList;
