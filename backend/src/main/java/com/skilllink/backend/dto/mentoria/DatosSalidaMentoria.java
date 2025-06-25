package com.skilllink.backend.dto.mentoria;

import com.skilllink.backend.entity.Mentoria;

import java.time.LocalDateTime;

public record DatosSalidaMentoria(
        Long idMentoria,
        Long idUsuario,
        String titulo,
        String descripcion,
        LocalDateTime fechaPublicacion,
        String estado) {

    public DatosSalidaMentoria(Mentoria mentoria) {
        this(mentoria.getIdMentoria(),
                mentoria.getUsuario().getIdUsuario(),
                mentoria.getTitulo(),
                mentoria.getDescripcion(),
                mentoria.getFechaPublicacion(),
                mentoria.getEstado());
    }
}
