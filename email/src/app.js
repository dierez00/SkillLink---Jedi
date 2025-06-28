import express from "express";
import emailRoutes from "./routes/emailRoutes.js";
import consumeMessages from "./services/rabbitServiceEvent.js";
import dotenv from "dotenv";

const app = express();

// Middleware para parsear JSON
app.use(express.json());

// Rutas de la API
app.use('/api/email', emailRoutes);

//Iniciar escucha de eventos en RabbitMQ
consumeMessages().catch((err) => {
    console.error("Error al iniciar RabbitMQ:", err);
});

export default app;