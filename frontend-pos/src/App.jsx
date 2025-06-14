import React, { useState } from 'react';
import ClientList from './ClientList';
import ProductList from './ProductList';
import SaleForm from './SaleForm';

function App() {
  const [activeTab, setActiveTab] = useState('inicio');

  const renderTab = () => {
    switch (activeTab) {
      case 'clientes':
        return <ClientList />;
      case 'productos':
        return <ProductList />;
      case 'ventas':
        return <SaleForm />;
      default:
        return <p className="lead">Bienvenido al sistema POS</p>;
    }
  };

  return (
    <div className="w-100 px-4 py-3">
      <h1 className="text-primary fw-bold">Sistema POS</h1>

      <ul className="nav nav-tabs mb-4">
        <li className="nav-item">
          <button
            className={`nav-link ${activeTab === 'inicio' ? 'active' : ''}`}
            onClick={() => setActiveTab('inicio')}
          >
            🏠 Inicio
          </button>
        </li>
        <li className="nav-item">
          <button
            className={`nav-link ${activeTab === 'clientes' ? 'active' : ''}`}
            onClick={() => setActiveTab('clientes')}
          >
            👥 Clientes
          </button>
        </li>
        <li className="nav-item">
          <button
            className={`nav-link ${activeTab === 'productos' ? 'active' : ''}`}
            onClick={() => setActiveTab('productos')}
          >
            📦 Productos
          </button>
        </li>
        <li className="nav-item">
          <button
            className={`nav-link ${activeTab === 'ventas' ? 'active' : ''}`}
            onClick={() => setActiveTab('ventas')}
          >
            💰 Ventas
          </button>
        </li>
      </ul>

      <main>{renderTab()}</main>
    </div>
  );
}

export default App;
