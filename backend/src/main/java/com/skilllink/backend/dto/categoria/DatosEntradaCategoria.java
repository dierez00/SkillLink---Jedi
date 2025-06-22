package com.skilllink.backend.dto.categoria;

import jakarta.validation.constraints.NotBlank;

public record DatosEntradaCategoria(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion) {
}
