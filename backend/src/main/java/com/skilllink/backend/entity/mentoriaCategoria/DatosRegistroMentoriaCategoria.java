package com.skilllink.backend.entity.mentoriaCategoria;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroMentoriaCategoria(
        @NotNull
        Long idMentoria,
        @NotNull
        Long idCategoria) {
}
