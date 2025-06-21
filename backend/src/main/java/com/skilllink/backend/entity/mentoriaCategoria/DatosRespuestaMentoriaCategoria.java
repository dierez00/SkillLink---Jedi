package com.skilllink.backend.entity.mentoriaCategoria;

public record DatosRespuestaMentoriaCategoria(
        Long idMentoriaCategoria,
        Long idMentoria,
        Long idCategoria) {

    public DatosRespuestaMentoriaCategoria(MentoriaCategoria mentoriaCategoria) {
        this(mentoriaCategoria.getIdMentoriaCategoria(),
                mentoriaCategoria.getMentoria().getIdMentoria(),
                mentoriaCategoria.getCategoria().getIdCategoria());
    }
}
