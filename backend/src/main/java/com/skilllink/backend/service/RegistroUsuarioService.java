package com.skilllink.backend.service;

import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.dto.usuario.UsuarioInfRegistro;
import com.skilllink.backend.mapper.UsuarioMapper;
import com.skilllink.backend.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistroUsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public Usuario registro(UsuarioInfRegistro usuarioInfRegistro){

        Usuario usuario = usuarioMapper.toEntity(usuarioInfRegistro);

        return usuarioRepository.save(usuario);
    }


}
