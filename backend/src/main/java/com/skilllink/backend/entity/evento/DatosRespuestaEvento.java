package com.skilllink.backend.entity.evento;

import java.time.LocalDateTime;

public record DatosRespuestaEvento(
        Long idEvento,
        String titulo,
        String descripcion,
        String ubicacion,
        LocalDateTime fechaEvento,
        String organizador) {
}
