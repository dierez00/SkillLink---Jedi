package com.skilllink.backend.dto.mentoriaCategoria;

import com.skilllink.backend.entity.MentoriaCategoria;

public record DatosSalidaMentoriaCategoria(
        Long idMentoriaCategoria,
        Long idMentoria,
        Long idCategoria) {

    public DatosSalidaMentoriaCategoria(MentoriaCategoria mentoriaCategoria) {
        this(mentoriaCategoria.getIdMentoriaCategoria(),
                mentoriaCategoria.getMentoria().getIdMentoria(),
                mentoriaCategoria.getCategoria().getIdCategoria());
    }
}
