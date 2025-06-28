import nodemailer from 'nodemailer';
import nodemailerExpressHandlebars from 'nodemailer-express-handlebars';
import dotenv from 'dotenv';
import path from 'path';

dotenv.config();

const transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: process.env.EMAIL_USER,
        pass: process.env.EMAIL_PASS
    }
});

const options = {
    viewEngine: {
        extName: '.hbs',  
        partialsDir: path.resolve('src/templates/'),  
        defaultLayout: false  
    },
    viewPath: path.resolve('src/templates/') 
};


transporter.use('compile', nodemailerExpressHandlebars(options));

export default transporter;