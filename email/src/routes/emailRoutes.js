import { sendEmail } from '../controllers/emailController.js';
import express from 'express';

const router = express.Router();

// Ruta de prueba para correos
router.post('/send', async (req, res) => {
    try {
        const emailData = req.body;
        await sendEmail(emailData);
        res.status(200).json({ message: 'Email sent successfully' });
    } catch (error) {
        console.error('Error sending email:', error);
        res.status(500).json({ error: 'Failed to send email' });
    }
});

export default router;