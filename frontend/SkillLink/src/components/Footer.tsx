import React from "react";
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <footer className="w-full bg-white border-t border-gray-300">
     
      <div className="max-w-9xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
        <div className="grid grid-cols-1 md:grid-cols-4 gap-8">
         
          <div className="space-y-4">
            <div className="flex items-center">
              <div className="bg-black p-2 rounded-lg mr-3">
                <svg
                  className="w-5 h-5 text-white"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    strokeWidth={2}
                    d="M13 10V3L4 14h7v7l9-11h-7z"
                  />
                </svg>
              </div>
              <span className="text-xl font-bold text-black">
                Skill
              </span>
            </div>
            <p className="text-gray-600 text-sm">
              Transformando ideas en realidad a través de soluciones digitales
              innovadoras.
            </p>
            <div className="flex space-x-4">
              {["twitter", "facebook", "instagram", "linkedin"].map((social) => (
                <a
                  key={social}
                  href="#"
                  className="text-gray-500 hover:text-black transition-colors"
                >
                  <span className="sr-only">{social}</span>
                  <svg
                    className="h-5 w-5"
                    fill="currentColor"
                    viewBox="0 0 24 24"
                    aria-hidden="true"
                  >
                    <path
                      fillRule="evenodd"
                      d="M12 2C6.477 2 2 6.484 2 12.017c0 4.425 2.865 8.18 6.839 9.504.5.092.682-.217.682-.483 0-.237-.008-.868-.013-1.703-2.782.605-3.369-1.343-3.369-1.343-.454-1.158-1.11-1.466-1.11-1.466-.908-.62.069-.608.069-.608 1.003.07 1.531 1.032 1.531 1.032.892 1.53 2.341 1.088 2.91.832.092-.647.35-1.088.636-1.338-2.22-.253-4.555-1.113-4.555-4.951 0-1.093.39-1.988 1.029-2.688-.103-.253-.446-1.272.098-2.65 0 0 .84-.27 2.75 1.026A9.564 9.564 0 0112 6.844c.85.004 1.705.115 2.504.337 1.909-1.296 2.747-1.027 2.747-1.027.546 1.379.202 2.398.1 2.651.64.7 1.028 1.595 1.028 2.688 0 3.848-2.339 4.695-4.566 4.943.359.309.678.92.678 1.855 0 1.338-.012 2.419-.012 2.747 0 .268.18.58.688.482A10.019 10.019 0 0022 12.017C22 6.484 17.522 2 12 2z"
                      clipRule="evenodd"
                    />
                  </svg>
                </a>
              ))}
            </div>
          </div>

         
          <div className="space-y-3">
            <h3 className="text-sm font-semibold text-black uppercase tracking-wider">
              Enlaces
            </h3>
            <nav className="space-y-2">
              {[
                { name: "Inicio", href: "/" },
                { name: "Características", href: "/features" },
                { name: "Precios", href: "/pricing" },
                { name: "Blog", href: "/blog" },
              ].map((item) => (
                <Link
                  key={item.name}
                  to={item.href}
                  className="text-gray-600 hover:text-black text-sm transition-colors block"
                >
                  {item.name}
                </Link>
              ))}
            </nav>
          </div>

       
          <div className="space-y-3">
            <h3 className="text-sm font-semibold text-black uppercase tracking-wider">
              Legal
            </h3>
            <nav className="space-y-2">
              {[
                { name: "Privacidad", href: "/privacy" },
                { name: "Términos", href: "/terms" },
                { name: "Cookies", href: "/cookies" },
              ].map((item) => (
                <Link
                  key={item.name}
                  to={item.href}
                  className="text-gray-600 hover:text-black text-sm transition-colors block"
                >
                  {item.name}
                </Link>
              ))}
            </nav>
          </div>

         
          <div className="space-y-3">
            <h3 className="text-sm font-semibold text-black uppercase tracking-wider">
              Newsletter
            </h3>
            <p className="text-gray-600 text-sm">
              Suscríbete para recibir las últimas actualizaciones.
            </p>
            <form className="flex space-x-2">
              <input
                type="email"
                placeholder="Tu email"
                className="flex-1 px-3 py-2 border border-gray-300 rounded-md text-sm focus:outline-none focus:ring-2 focus:ring-black focus:border-transparent"
                required
              />
              <button
                type="submit"
                className="bg-black text-white px-4 py-2 rounded-md text-sm font-medium hover:opacity-90 transition-opacity"
              >
                OK
              </button>
            </form>
          </div>
        </div>

       
        <div className="mt-12 pt-8 border-t border-gray-300 flex flex-col md:flex-row justify-between items-center">
          <p className="text-gray-500 text-sm">© 2025 Skill. Todos los derechos reservados.</p>
          <div className="flex space-x-6 mt-4 md:mt-0">
            <p className="text-gray-500 text-sm">Hecho por alumno ONE</p>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;