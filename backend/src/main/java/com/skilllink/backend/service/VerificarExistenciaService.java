package com.skilllink.backend.service;

import com.skilllink.backend.entity.categoria.Categoria;
import com.skilllink.backend.entity.categoria.CategoriaRepository;
import com.skilllink.backend.entity.evento.Evento;
import com.skilllink.backend.entity.evento.EventoRepository;
import com.skilllink.backend.entity.mentoria.Mentoria;
import com.skilllink.backend.entity.mentoria.MentoriaRepository;
import com.skilllink.backend.entity.usuario.Usuario;
import com.skilllink.backend.entity.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificarExistenciaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Usuario hayUsuario(Long idUsuario) {
        if (!usuarioRepository.findById(idUsuario).isPresent()) {
            throw new RuntimeException("Este id para el usuario no fue encontrado");
        }
        return usuarioRepository.findById(idUsuario).get();
    }

    public Evento hayEvento(Long idEvento) {
        if (!eventoRepository.findById(idEvento).isPresent()) {
            throw new RuntimeException("Este id para el evento no fue encontrado");
        }
        return eventoRepository.findById(idEvento).get();
    }

    public Mentoria hayMentoria(Long idMentoria) {
        if (!mentoriaRepository.findById(idMentoria).isPresent()) {
            throw new RuntimeException("Este id para la mentoria no fue encontrado");
        }
        return mentoriaRepository.findById(idMentoria).get();
    }

    public Categoria hayCategoria(Long idCategoria) {
        if (!categoriaRepository.findById(idCategoria).isPresent()) {
            throw new RuntimeException("Este id para la categoria no fue encontrado");
        }
        return categoriaRepository.findById(idCategoria).get();
    }
}
