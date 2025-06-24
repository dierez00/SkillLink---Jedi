package com.skilllink.backend.service;

import com.skilllink.backend.entity.usuario.Usuario;
import com.skilllink.backend.repository.UsuarioRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDeUsuario {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public Usuario consultarUsuario (Long idUsuario) {
        return usuarioRepositorio.findById(idUsuario).orElseThrow(
                () -> new EntityNotFoundException("No se encontro al usuario"));
    }

    public void eliminarUsuario (Long idUsuario){
        usuarioRepositorio.deleteById(idUsuario);
    }

}
