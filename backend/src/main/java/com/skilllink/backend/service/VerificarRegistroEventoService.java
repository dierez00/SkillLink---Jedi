package com.skilllink.backend.service;

import com.skilllink.backend.entity.evento.Evento;
import com.skilllink.backend.entity.evento.EventoRepository;
import com.skilllink.backend.entity.usuario.Usuario;
import com.skilllink.backend.entity.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificarRegistroEventoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EventoRepository eventoRepository;

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
}
