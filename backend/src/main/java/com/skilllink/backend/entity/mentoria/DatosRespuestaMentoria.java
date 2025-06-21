package com.skilllink.backend.entity.mentoria;

import java.time.LocalDateTime;

public record DatosRespuestaMentoria(
        Long idMentoria,
        Long idUsuario,
        String titulo,
        String descripcion,
        LocalDateTime fechaPublicacion,
        String estado) {

    public DatosRespuestaMentoria(Mentoria mentoria) {
        this(mentoria.getIdMentoria(),
                mentoria.getUsuario().getIdUsuario(),
                mentoria.getTitulo(),
                mentoria.getDescripcion(),
                mentoria.getFechaPublicacion(),
                mentoria.getEstado());
    }
}
