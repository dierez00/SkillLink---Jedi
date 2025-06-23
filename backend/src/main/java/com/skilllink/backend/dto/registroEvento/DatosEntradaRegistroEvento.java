package com.skilllink.backend.dto.registroEvento;

import jakarta.validation.constraints.NotNull;

public record DatosEntradaRegistroEvento(
        @NotNull
        Long idUsuario,
        @NotNull
        Long idEvento) {
}
