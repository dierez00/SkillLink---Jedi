package com.skilllink.backend.entity.perfil;


import com.skilllink.backend.entity.perfilHabilidad.HabilidadesSeleccionadas;

import java.util.List;

public record DatosDeSalidaPerfil(String nombre, String descripcion, String experiencia, String ubicacion, String redesSociales, List<HabilidadesSeleccionadas> habilidades) {
}
