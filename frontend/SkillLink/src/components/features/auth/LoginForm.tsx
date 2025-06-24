// src/features/auth/Login.tsx
import { type FormEvent, useId } from "react";
import { Link, useNavigate } from "react-router-dom";
import Input from "../../ui/Input";

// import Input from "../../ui/Input";

const LoginForm = () => {
  const navigate = useNavigate();

  const handleLogin = (e: FormEvent) => {
    e.preventDefault();
    // Lógica de autenticación
    navigate("/");
  };

  const idCheck = useId();

  return (
    <div className="min-h-screen bg-white/45 flex items-center justify-center p-4">
      <div className="w-full max-w-md">
        <div className="bg-white rounded-2xl shadow-xl overflow-hidden">
          <div className="p-8">
            <div className="text-center mb-8">
              <h1 className="text-3xl font-bold text-gray-800 mb-2">
                Bienvenido de nuevo
              </h1>
              <p className="text-gray-600">
                Ingresa tus credenciales para acceder
              </p>
            </div>

            <form onSubmit={handleLogin} className="space-y-6">
              <Input
                name="Correo electrónico"
                type="email"
                placeholder="ejemplo@gmail.com"
                required
              />

              <Input name="Contraseña" type="password" required />

              <div className="flex items-center justify-between">
                <div className="flex items-center">
                  <label
                    htmlFor={idCheck}
                    className="ml-2 block text-sm text-gray-700"
                  >
                    Recordarme
                  </label>
                  <input
                    id={idCheck}
                    name="remember-me"
                    type="checkbox"
                    className="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded"
                  />
                </div>

                <div className="text-sm">
                  <Link
                    to="/forgot-password"
                    className="font-medium text-indigo-600 hover:text-indigo-500"
                  >
                    ¿Olvidaste tu contraseña?
                  </Link>
                </div>
              </div>

              <button
                type="submit"
                className="w-full bg-gradient-to-r from-indigo-600 to-blue-600 hover:from-indigo-700 hover:to-blue-700 text-white font-medium py-3 px-4 rounded-lg shadow-md hover:shadow-lg transition duration-200"
              >
                Iniciar sesión
              </button>
            </form>
          </div>

          <div className="bg-gray-50 px-8 py-6 rounded-b-2xl text-center">
            <p className="text-gray-600 text-sm">
              ¿No tienes una cuenta?{" "}
              <Link
                to="/register"
                className="font-medium text-indigo-600 hover:text-indigo-500"
              >
                Regístrate
              </Link>
            </p>
          </div>
        </div>

        <div className="mt-6 text-center text-xs text-gray-500">
          © {new Date().getFullYear()} Tu Empresa. Todos los derechos
          reservados.
        </div>
      </div>
    </div>
  );
};

export default LoginForm;
