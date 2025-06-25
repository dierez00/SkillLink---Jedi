// src/features/auth/Register.tsx
import type { FormEvent } from "react";
import { Link, useNavigate } from "react-router-dom";
import Input from "../../ui/Input";

const Register = () => {
  const navigate = useNavigate();

  const handleRegister = (e: FormEvent) => {
    e.preventDefault();
    // Lógica de registro
    navigate("/login");
  };

  return (
    <div className="min-h-screen bg-white/45 flex items-center justify-center p-4">
      <div className="w-full max-w-md">
        <div className="bg-white rounded-2xl shadow-xl overflow-hidden">
          <div className="p-8">
            <div className="text-center mb-8">
              <h1 className="text-3xl font-bold text-gray-800 mb-2">
                Crea tu cuenta
              </h1>
              <p className="text-gray-600">
                Comienza tu experiencia con nosotros
              </p>
            </div>

            <form onSubmit={handleRegister} className="space-y-5">
              <Input
                name="Nombre completo"
                type="text"
                placeholder="ej: Juan Pérez"
                required
              />

              <Input
                name="Correo electrónico"
                type="email"
                placeholder="skill@one.com"
                required
              />

              <Input name="Contraseña" type="password" required />

              <div className="flex items-start">
                <div className="ml-3 text-sm">
                  <label htmlFor="terms" className="font-light text-gray-700">
                    <input
                      name="terms"
                      type="checkbox"
                      required
                      className="h-4 w-4 mr-1 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded"
                    />
                    Acepto los{" "}
                    <a
                      href="#top"
                      className="font-medium text-indigo-600 hover:text-indigo-500"
                    >
                      Términos
                    </a>{" "}
                    y{" "}
                    <a
                      href="#top"
                      className="font-medium text-indigo-600 hover:text-indigo-500"
                    >
                      Política de Privacidad
                    </a>
                  </label>
                </div>
              </div>

              <button
                type="submit"
                className="w-full bg-gradient-to-r from-green-600 to-emerald-600 hover:from-green-700 hover:to-emerald-700 text-white font-medium py-3 px-4 rounded-lg shadow-md hover:shadow-lg transition duration-200"
              >
                Registrarse
              </button>
            </form>
          </div>

          <div className="bg-gray-50 px-8 py-6 rounded-b-2xl text-center">
            <p className="text-gray-600 text-sm">
              ¿Ya tienes una cuenta?{" "}
              <Link
                to="/login"
                className="font-medium text-indigo-600 hover:text-indigo-500"
              >
                Inicia sesión
              </Link>
            </p>
          </div>
        </div>

        <div className="mt-6 text-center text-xs text-gray-500">
          © {new Date().getFullYear()} Skill. Todos los derechos reservados.
        </div>
      </div>
    </div>
  );
};

export default Register;
