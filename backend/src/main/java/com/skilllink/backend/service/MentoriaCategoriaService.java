package com.skilllink.backend.service;

import com.skilllink.backend.dto.mentoriaCategoria.DatosEntradaMentoriaCategoria;
import com.skilllink.backend.entity.Categoria;
import com.skilllink.backend.entity.Mentoria;
import com.skilllink.backend.entity.MentoriaCategoria;
import com.skilllink.backend.repository.CategoriaRepository;
import com.skilllink.backend.repository.MentoriaCategoriaRepository;
import com.skilllink.backend.repository.MentoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentoriaCategoriaService {

    @Autowired
    private MentoriaCategoriaRepository mentoriaCategoriaRepository;

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public MentoriaCategoria actualizar(Long id, DatosEntradaMentoriaCategoria datosEntradaMentoriaCategoria) {
        MentoriaCategoria mentoriaCategoria = mentoriaCategoriaRepository.getReferenceById(id);
        Mentoria mentoria = mentoriaRepository.getReferenceById(datosEntradaMentoriaCategoria.idMentoria());
        mentoriaCategoria.setMentoria(mentoria);
        Categoria categoria = categoriaRepository.getReferenceById(datosEntradaMentoriaCategoria.idCategoria());
        mentoriaCategoria.setCategoria(categoria);
        return mentoriaCategoria;
    }
}
