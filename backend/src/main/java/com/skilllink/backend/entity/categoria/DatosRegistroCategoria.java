package com.skilllink.backend.entity.categoria;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCategoria(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion) {
}
