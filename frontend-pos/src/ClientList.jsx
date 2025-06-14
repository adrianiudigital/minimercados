import React, { useEffect, useState } from 'react';

function ClientList() {
  const [clients, setClients] = useState([]);
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [documento, setDocumento] = useState('');
  const [phone, setPhone] = useState('');
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetchClients();
  }, []);

  const fetchClients = () => {
    fetch('http://localhost:8080/clients')
      .then(res => res.json())
      .then(data => setClients(data))
      .catch(() => setMessage('❌ Error al cargar clientes.'));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const clientData = {
      name,
      email,
      document: documento,
      phone
    };

    try {
      const response = await fetch('http://localhost:8080/clients', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(clientData),
      });

      if (response.ok) {
        setMessage('✅ Cliente creado correctamente');
        setName('');
        setEmail('');
        setDocumento('');
        setPhone('');
        fetchClients();
      } else {
        setMessage('❌ Error al crear cliente.');
      }
    } catch (err) {
      console.error(err);
      setMessage('❌ Error de conexión al servidor.');
    }
  };

  return (
    <div className="row">
      {/* Formulario para crear cliente */}
      <div className="col-md-4">
        <h4 className="mb-3">Crear Cliente</h4>
        <form onSubmit={handleSubmit}>
          <div className="mb-2">
            <label className="form-label">Nombre</label>
            <input type="text" className="form-control" value={name} onChange={(e) => setName(e.target.value)} required />
          </div>
          <div className="mb-2">
            <label className="form-label">Correo</label>
            <input type="email" className="form-control" value={email} onChange={(e) => setEmail(e.target.value)} required />
          </div>
          <div className="mb-2">
            <label className="form-label">Documento</label>
            <input type="text" className="form-control" value={documento} onChange={(e) => setDocumento(e.target.value)} required />
          </div>
          <div className="mb-2">
            <label className="form-label">Teléfono</label>
            <input type="text" className="form-control" value={phone} onChange={(e) => setPhone(e.target.value)} required />
          </div>
          <button type="submit" className="btn btn-primary w-100">Guardar Cliente</button>
        </form>

        {message && <div className="alert alert-info mt-3">{message}</div>}
      </div>

      {/* Tabla de clientes */}
      <div className="col-md-8">
        <h4 className="mb-3">Lista de Clientes</h4>
        <table className="table table-striped table-bordered">
          <thead className="table-dark">
            <tr>
              <th>Nombre</th>
              <th>Email</th>
              <th>Documento</th>
              <th>Teléfono</th>
            </tr>
          </thead>
          <tbody>
            {clients.map(c => (
              <tr key={c.id}>
                <td>{c.name}</td>
                <td>{c.email}</td>
                <td>{c.document}</td>
                <td>{c.phone}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ClientList;
