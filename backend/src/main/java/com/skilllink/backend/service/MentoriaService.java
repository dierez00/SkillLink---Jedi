package com.skilllink.backend.service;

import com.skilllink.backend.dto.mentoria.DatosEntradaMentoria;
import com.skilllink.backend.entity.Mentoria;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.repository.MentoriaRepository;
import com.skilllink.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentoriaService {

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Mentoria actualizar(Long id, DatosEntradaMentoria datosEntradaMentoria) {
        Mentoria mentoria = mentoriaRepository.getReferenceById(id);
        Usuario usuario = usuarioRepository.getReferenceById(datosEntradaMentoria.idUsuario());
        mentoria.setUsuario(usuario);
        mentoria.setTitulo(datosEntradaMentoria.titulo());
        mentoria.setDescripcion(datosEntradaMentoria.descripcion());
        mentoria.setFechaPublicacion(datosEntradaMentoria.fechaPublicacion());
        mentoria.setEstado(datosEntradaMentoria.estado());
        return mentoria;
    }
}
