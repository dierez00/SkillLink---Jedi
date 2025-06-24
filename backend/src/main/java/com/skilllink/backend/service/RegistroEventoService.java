package com.skilllink.backend.service;

import com.skilllink.backend.dto.registroEvento.DatosEntradaRegistroEvento;
import com.skilllink.backend.entity.Evento;
import com.skilllink.backend.entity.RegistroEvento;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.repository.EventoRepository;
import com.skilllink.backend.repository.RegistroEventoRepository;
import com.skilllink.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistroEventoService {

    @Autowired
    private RegistroEventoRepository registroEventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public RegistroEvento actualizar(Long id, DatosEntradaRegistroEvento datosEntradaRegistroEvento) {
        RegistroEvento registroEvento = registroEventoRepository.getReferenceById(id);
        Usuario usuario = usuarioRepository.getReferenceById(datosEntradaRegistroEvento.idUsuario());
        registroEvento.setUsuario(usuario);
        Evento evento = eventoRepository.getReferenceById(datosEntradaRegistroEvento.idEvento());
        registroEvento.setEvento(evento);
        registroEvento.setFechaRegistro(LocalDateTime.now());
        return registroEvento;
    }

}
