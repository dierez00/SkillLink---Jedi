import transporter from "../config/emailConfig.js";
import dotenv from "dotenv";

export const sendEmail = async (emailData) => {
    try {
        const { to, subject, template, context } = emailData;

        // Configurar el correo electrónico
        const mailOptions = {
            from: process.env.EMAIL_USER,
            to,
            subject,
            template,
            context
        };

        // Enviar el correo electrónico
        await transporter.sendMail(mailOptions);
        console.log(`Email sent to ${to}`);
    } catch (error) {
        console.error("Error sending email:", error);
        throw error; 
    }
}

export const enviarCorreoDeBienvenida = async ({ name, email }) => {
  try {
    await transporter.sendMail({
      from: `"SkillLink" <${process.env.EMAIL_USER}>`,
      to: email,
      subject: `¡Bienvenido a SkillLink, ${name}!`,
      template: 'welcome',
      context: {
        name,
        year: new Date().getFullYear(),
      },
    });

    console.log(`Correo enviado correctamente a ${email}`);
  } catch (error) {
    console.error(`Error al enviar correo a ${email}:`, error);
  }
};

export const enviarCorreoRecuperacion = async ({ email, token }) => {
  const link = `${process.env.FRONTEND_URL}/reset-password?token=${token}`;

  try {
    await transporter.sendMail({
      from: `"SkillLink" <${process.env.EMAIL_USER}>`,
      to: email,
      subject: "Recupera tu contraseña - SkillLink",
      template: 'recover', 
      context: {
        link,
        year: new Date().getFullYear()
      }
    });

    console.log(`Correo de recuperación enviado a ${email}`);
  } catch (error) {
    console.error(`Error al enviar recuperación a ${email}:`, error);
  }
};