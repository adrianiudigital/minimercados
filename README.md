# 🛒 Sistema de Gestión de Minimercado

Este proyecto es una solución completa para la gestión de un minimercado. Permite administrar productos, clientes y registrar ventas de forma sencilla, con un historial consultable y la posibilidad de generar reportes en PDF.

---

## 🚀 Tecnologías usadas

### Backend
- Java 17
- Spring Boot
- Maven
- H2 (modo desarrollo)
- PostgreSQL (modo producción)
- JPA (Hibernate)

### Frontend
- React.js
- Bootstrap 5
- jsPDF + jsPDF AutoTable (para PDF)

---

## 📦 Estructura del Proyecto

```
minimercados/
│
├── backend-pos/
│   └── src/main/java/co/edu/iudigital/pos/...
│   └── pom.xml
│
├── frontend-pos/
│   └── src/
│       └── components/
│       └── App.jsx
│       └── main.jsx
│   └── package.json
│
├── README.md
└── .gitignore
```

---

## ⚙️ Cómo ejecutar

### Backend
```bash
cd backend-pos
mvn spring-boot:run
```

### Frontend
```bash
cd frontend-pos
npm install
npm run dev
```

---

## 🧾 Funcionalidades

- ✅ Registrar y listar productos.
- ✅ Registrar y listar clientes.
- ✅ Registrar ventas con selección de cliente y producto.
- ✅ Historial de ventas con filtro por cliente.
- ✅ Reporte en PDF del historial de ventas.

---

## 📋 Requisitos

- JDK 17
- Node.js 18+
- Maven
- Git

---

## 👨‍💻 Autor

Desarrollado con por **Adrián Costa**  
Valledupar, Colombia  


