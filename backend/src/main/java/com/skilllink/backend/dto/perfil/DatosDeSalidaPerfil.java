package com.skilllink.backend.dto.perfil;


import com.skilllink.backend.dto.perfilHabilidad.HabilidadesSeleccionadas;

import java.util.List;

public record DatosDeSalidaPerfil(String nombre,
                                  String descripcion, String experiencia, String ubicacion, String redesSociales,
                                  List<HabilidadesSeleccionadas> habilidades) {
}
