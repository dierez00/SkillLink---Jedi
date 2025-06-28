const API_URL = import.meta.env.VITE_API_URL;

export async function getProjects() {
  const res = await fetch(`${API_URL}/proyectos`);
  if (!res.ok) throw new Error("Error al obtener proyectos");
  return res.json();
}

export async function createProject(data: any) {
  const res = await fetch(`${API_URL}/proyectos`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Error al crear proyecto");
  return res.json();
}