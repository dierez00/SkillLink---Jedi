package com.skilllink.backend.entity.registroEvento;

import java.time.LocalDateTime;

public record DatosRespuestaRegistroEvento(
        Long idRegistro,
        Long idUsuario,
        Long idEvento,
        LocalDateTime fechaRegistro) {
}
