package com.skilllink.backend.dto.mentoriaCategoria;

import jakarta.validation.constraints.NotNull;

public record DatosEntradaMentoriaCategoria(
        @NotNull
        Long idMentoria,
        @NotNull
        Long idCategoria) {
}
