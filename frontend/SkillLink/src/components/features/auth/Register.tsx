import type { FormEvent } from "react";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Input from "../../ui/Input";
import { toast } from "react-hot-toast";

interface RegisterData {
  nombre: string;
  email: string;
  contrasena: string;
}

const Register = () => {
  const navigate = useNavigate();
  const [isLoading, setIsLoading] = useState(false);
  const [formData, setFormData] = useState<RegisterData>({
    nombre: "",
    email: "",
    contrasena: "",
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleRegister = async (e: FormEvent) => {
    e.preventDefault();

 
    if (!formData.nombre || !formData.email || !formData.contrasena) {
      toast.error("Por favor completa todos los campos");
      return;
    }

    setIsLoading(true);

    try {
      const response = await fetch("http://localhost:8081/api/registro", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          nombre: formData.nombre,
          email: formData.email,
          contrasena: formData.contrasena
        }),
      });

      const text = await response.text();
      let data;
      try {
        data = text ? JSON.parse(text) : {};
      } catch (error) {
        data = {};
      }

      if (!response.ok) {
        throw new Error(data.message || "Error en el registro");
      }

      toast.success("¡Registro exitoso! Por favor inicia sesión");
      navigate("/login");
    } catch (error) {
      console.error("Error en el registro:", error);
      toast.error(error instanceof Error ? error.message : "Error en el registro");
    } finally {
      setIsLoading(false);
    }
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
                label="Nombre completo"
                name="nombre"
                type="text"
                placeholder="ej: Juan Pérez"
                required
                value={formData.nombre}
                onChange={handleChange}
              />

              <Input
                label="Correo electrónico"
                name="email"
                type="email"
                placeholder="tu@email.com"
                required
                value={formData.email}
                onChange={handleChange}
              />

              <Input
                label="Contraseña"
                name="contrasena"
                type="password"
                required
                value={formData.contrasena}
                onChange={handleChange}
                minLength={6}
              />

              <div className="flex items-start">
                <div className="flex items-center h-5">
                  <input
                    id="terms"
                    name="terms"
                    type="checkbox"
                    required
                    className="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded"
                  />
                </div>
                <div className="ml-3 text-sm">
                  <label htmlFor="terms" className="font-light text-gray-700">
                    Acepto los{" "}
                    <a href="#" className="font-medium text-indigo-600 hover:text-indigo-500">
                      Términos
                    </a>{" "}
                    y{" "}
                    <a href="#" className="font-medium text-indigo-600 hover:text-indigo-500">
                      Política de Privacidad
                    </a>
                  </label>
                </div>
              </div>

              <button
                type="submit"
                disabled={isLoading}
                className={`w-full bg-gradient-to-r from-green-600 to-emerald-600 hover:from-green-700 hover:to-emerald-700 text-white font-medium py-3 px-4 rounded-lg shadow-md hover:shadow-lg transition duration-200 ${
                  isLoading ? "opacity-70 cursor-not-allowed" : ""
                }`}
              >
                {isLoading ? (
                  <span className="flex items-center justify-center">
                    <svg className="animate-spin -ml-1 mr-3 h-5 w-5 text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
                      <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4"></circle>
                      <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
                    </svg>
                    Procesando...
                  </span>
                ) : (
                  "Registrarse"
                )}
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
