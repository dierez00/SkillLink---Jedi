package com.skilllink.backend.entity.registroEvento;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroRegistroEvento(
        @NotNull
        Long idUsuario,
        @NotNull
        Long idEvento) {
}
