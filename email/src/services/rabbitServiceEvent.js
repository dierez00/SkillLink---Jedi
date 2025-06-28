import amqp from 'amqplib';
import dotenv from 'dotenv';
import {
  enviarCorreoDeBienvenida,
  enviarCorreoRecuperacion
} from '../controllers/emailController.js';

dotenv.config();

const queue = 'emailQueue';
const url = process.env.CLOUDAMQP_URL;

const consumeMessages = async () => {
  try {
    const conn = await amqp.connect(url);
    const channel = await conn.createChannel();
    await channel.assertQueue(queue, { durable: false });

    console.log(`Esperando mensajes en la cola '${queue}'...`);

    channel.consume(queue, async (msg) => {
      if (msg !== null) {
        const data = JSON.parse(msg.content.toString());
        console.log("📨 Mensaje recibido:", data);

        if (data.type === 'welcome') {
          await enviarCorreoDeBienvenida({
            name: data.name,
            email: data.email
          });
        } else if (data.type === 'recover') {
          await enviarCorreoRecuperacion({
            email: data.email,
            token: data.token
          });
        } else {
          console.warn("Tipo de mensaje no reconocido:", data);
        }

        channel.ack(msg);
      }
    });
  } catch (err) {
    console.error('Error conectando a RabbitMQ:', err);
  }
};

export default consumeMessages;
