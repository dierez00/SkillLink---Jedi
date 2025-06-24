package com.skilllink.backend.dto.perfilHabilidad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HabilidadesSeleccionadas(
        @NotNull
        Long idHabildad,
        @NotBlank
        String nivel,
        @NotNull
        int anosDeExperiencia) {
}
