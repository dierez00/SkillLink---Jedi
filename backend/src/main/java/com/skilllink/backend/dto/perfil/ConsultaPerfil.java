package com.skilllink.backend.dto.perfil;

import com.skilllink.backend.dto.perfilHabilidad.HabilidadesPerfil;

import java.util.List;

public record ConsultaPerfil(String nombre, String descripcion, String experiencia,
                             String ubicacion, String redesSociales,
                             List<HabilidadesPerfil> habilidades) {
}
