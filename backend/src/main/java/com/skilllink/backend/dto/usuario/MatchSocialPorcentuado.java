package com.skilllink.backend.dto.usuario;

import java.math.BigDecimal;

public record MatchSocialPorcentuado(
        Long idUsuario,
        String nombre,
        Long habilidadesComunes,
        Long numeroBase,
        BigDecimal porcentaje
) {
}

