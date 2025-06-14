-- src/main/resources/data.sql
-- Datos de prueba para H2 y MySQL

-- Roles
INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'VENDEDOR');

-- Usuarios
INSERT INTO usuarios (id, username, email, password, role_id)
VALUES (1, 'adminuser', 'admin@example.com', '1234', 1);
INSERT INTO usuarios (id, username, email, password, role_id)
VALUES (2, 'vendedor1', 'vendedor@example.com', '1234', 2);


-- Clientes
INSERT INTO clientes (id, document, name, phone, email)
VALUES (1, '1234567890', 'Cliente Real',  '3010000000', 'cliente@correo.com');
INSERT INTO clientes (id, document, name, phone, email)
VALUES (5, '1234567890', 'Cliente Prueba', '3011234567', 'cliente@correo.com');

-- Proveedores
INSERT INTO proveedores (
  id, nit, name, address, phone, web_site, created_at, updated_at
) VALUES (
  1,
  '900123456',
  'Proveedor Uno',
  'Calle 10',
  '3000000000',
  'http://proveedor.com',
  NOW(),
  NOW()
);

-- Categorías
INSERT INTO categorias (id, name) VALUES (1, 'Abarrotes');

-- Productos
INSERT INTO productos (
  id, name, description, price, stock, category_id, provider_id
) VALUES (
  1,
  'Producto A',
  'Producto de prueba',
  5000,
  100,
  1,
  1
);
