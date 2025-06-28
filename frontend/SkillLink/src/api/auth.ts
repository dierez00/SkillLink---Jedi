export interface LoginData {
  email: string;
  contrasena: string;
}

export async function loginUser({ email, contrasena }: LoginData) {

  const url = import.meta.env.VITE_API_URL;
  const response = await fetch(`${url}/api/ingresar`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ email, contrasena }),
  });

  if (!response.ok) {
    throw new Error("Credenciales incorrectas");
  }

  return response.json();
}

export interface RegisterData {
  nombre: string;
  email: string;
  contrasena: string;
}

export async function registerUser({ nombre, email, contrasena }: RegisterData) {
  const response = await fetch(`${import.meta.env.VITE_API_URL}/registro`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ nombre, email, contrasena }),
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

  return data;
}