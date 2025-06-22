package com.skilllink.backend.dto.mentoria;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosEntradaMentoria(
        @NotNull
        Long idUsuario,
        @NotBlank
        String titulo,
        @NotBlank
        String descripcion,
        @NotNull
        @Future
        LocalDateTime fechaPublicacion,
        @NotBlank
        String estado) {
}
