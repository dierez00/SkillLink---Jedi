const API_URL = import.meta.env.VITE_API_URL;

function getToken() {
  return localStorage.getItem("token");
}

export async function getProjects() {
  const token = getToken();

  const res = await fetch(`${API_URL}/api/proyectos`, {
    headers: {
      "Content-Type": "application/json",
      "Authorization": `Bearer ${token}`,
    },
  });

  if (!res.ok) throw new Error("Error al obtener proyectos");
  return res.json();
}

export async function createProject(data: any) {
  const token = getToken();

  const res = await fetch(`${API_URL}/api/proyectos`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Authorization": `Bearer ${token}`,
    },
    body: JSON.stringify(data),
  });

  if (!res.ok) throw new Error("Error al crear proyecto");
  return res.json();
}
