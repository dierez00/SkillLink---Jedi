const API_URL = import.meta.env.VITE_API_URL;

export async function getMyProfile() {
  const res = await fetch(`${API_URL}/perfil/mi-cuenta`, {
    credentials: "include",
  });
  if (!res.ok) throw new Error("Error al obtener perfil");
  return res.json();
}

export async function updateProfile(data: any) {
  const res = await fetch(`${API_URL}/perfil/actualizar`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    credentials: "include",
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Error al actualizar perfil");
  return res.json();
}