package com.skilllink.backend.dto.evento;

import com.skilllink.backend.entity.Evento;

import java.time.LocalDateTime;

public record DatosSalidaEvento(
        Long idEvento,
        String titulo,
        String descripcion,
        String ubicacion,
        LocalDateTime fechaEvento,
        String organizador) {

    public DatosSalidaEvento(Evento evento) {
        this(evento.getIdEvento(),
                evento.getTitulo(),
                evento.getDescripcion(),
                evento.getUbicacion(),
                evento.getFechaEvento(),
                evento.getOrganizador());
    }
}
