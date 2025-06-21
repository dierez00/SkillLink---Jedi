package com.skilllink.backend.entity.registroEvento;

import java.time.LocalDateTime;

public record DatosRespuestaRegistroEvento(
        Long idRegistro,
        Long idUsuario,
        Long idEvento,
        LocalDateTime fechaRegistro) {

    public DatosRespuestaRegistroEvento(RegistroEvento registroEvento) {
        this(registroEvento.getIdRegistro(),
                registroEvento.getUsuario().getIdUsuario(),
                registroEvento.getEvento().getIdEvento(),
                registroEvento.getFechaRegistro());
    }
}
