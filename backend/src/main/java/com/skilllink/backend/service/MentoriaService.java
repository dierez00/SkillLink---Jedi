package com.skilllink.backend.service;

import com.skilllink.backend.dto.evento.DatosEntradaEvento;
import com.skilllink.backend.dto.mentoria.DatosEntradaMentoria;
import com.skilllink.backend.entity.Evento;
import com.skilllink.backend.entity.Mentoria;
import com.skilllink.backend.repository.EventoRepository;
import com.skilllink.backend.repository.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentoriaService {

    @Autowired
    private MentoriaRepository mentoriaRepository;

    public Mentoria actualizar(Long id, DatosEntradaMentoria datosEntradaMentoria) {
        Mentoria mentoria = mentoriaRepository.getReferenceById(id);
        mentoria.getUsuario().setIdUsuario(datosEntradaMentoria.idUsuario());
        mentoria.setTitulo(datosEntradaMentoria.titulo());
        mentoria.setDescripcion(datosEntradaMentoria.descripcion());
        mentoria.setFechaPublicacion(datosEntradaMentoria.fechaPublicacion());
        mentoria.setEstado(datosEntradaMentoria.estado());
        return mentoria;
    }
}
