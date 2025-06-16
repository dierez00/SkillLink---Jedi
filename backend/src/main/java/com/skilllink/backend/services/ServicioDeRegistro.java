package com.skilllink.backend.services;

import com.skilllink.backend.dto.UsuarioInfRegistro;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicioDeRegistro {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registro (UsuarioInfRegistro usuarioInfRegistro){

        String contrasenaEncriptada = passwordEncoder.encode(usuarioInfRegistro.contrasena());

        Usuario nuevoUsuario = new Usuario(null,
                usuarioInfRegistro.nombre(),
                usuarioInfRegistro.email(),
                contrasenaEncriptada,
                usuarioInfRegistro.rol(),
                LocalDateTime.now());

        return usuarioRepositorio.save(nuevoUsuario);

    }


}
