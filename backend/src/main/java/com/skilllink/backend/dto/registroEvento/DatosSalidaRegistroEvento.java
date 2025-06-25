package com.skilllink.backend.dto.registroEvento;

import com.skilllink.backend.entity.RegistroEvento;

import java.time.LocalDateTime;

public record DatosSalidaRegistroEvento(
        Long idRegistro,
        Long idUsuario,
        Long idEvento,
        LocalDateTime fechaRegistro) {

    public DatosSalidaRegistroEvento(RegistroEvento registroEvento) {
        this(registroEvento.getIdRegistro(),
                registroEvento.getUsuario().getIdUsuario(),
                registroEvento.getEvento().getIdEvento(),
                registroEvento.getFechaRegistro());
    }
}
