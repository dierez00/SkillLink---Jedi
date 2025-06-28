
const API_URL = `${import.meta.env.VITE_API_URL}/desafios`;



export async function getDesafios() {
  const response = await fetch(API_URL);
  if (!response.ok) throw new Error("Error al obtener desafíos");
  return await response.json();
}


export async function createDesafio(data: {
  titulo: string;
  descripcion: string;
  dificultad: string;
  fecha_limite: string; 
  estado: string;       
  id_usuario: number;   
}) {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!response.ok) throw new Error("Error al crear desafío");
  return await response.json();
}


export async function deleteDesafio(id: number) {
  const response = await fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });
  if (!response.ok) throw new Error("Error al eliminar desafío");
  return true;
}
