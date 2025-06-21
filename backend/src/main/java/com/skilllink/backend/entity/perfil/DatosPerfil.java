package com.skilllink.backend.entity.perfil;

import com.skilllink.backend.entity.perfilHabilidad.HabilidadesSeleccionadas;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DatosPerfil(
        @NotBlank (message = "Coloca tu biografia/descripcion")
        String descripcion,

        String experiencia,

        String ubicacion,

        @NotBlank(message = "Ingresa tu perfil de Git-Hub o Linkedin")
        String redesSociales,

        List<HabilidadesSeleccionadas> habilidades){
}
