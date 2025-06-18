package com.skilllink.backend.entity.evento;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroEvento(
        @NotBlank
        String titulo,
        @NotBlank
        String descripcion,
        @NotBlank
        String ubicacion,
        @NotNull
        @Future
        LocalDateTime fechaEvento,
        @NotBlank
        String organizador) {
}
