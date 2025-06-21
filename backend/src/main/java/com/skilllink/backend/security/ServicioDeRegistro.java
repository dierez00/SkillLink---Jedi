package com.skilllink.backend.security;

import com.skilllink.backend.entity.usuario.Usuario;
import com.skilllink.backend.entity.usuario.UsuarioInfRegistro;
import com.skilllink.backend.entity.usuario.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicioDeRegistro {

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registro(UsuarioInfRegistro usuarioInfRegistro){

        String contrasenaEncriptada = passwordEncoder.encode(usuarioInfRegistro.contrasena());

        Usuario nuevoUsuario = new Usuario();

        nuevoUsuario.setNombre(usuarioInfRegistro.nombre());
        nuevoUsuario.setEmail(usuarioInfRegistro.email());
        nuevoUsuario.setContrasena(contrasenaEncriptada);
        nuevoUsuario.setRol(usuarioInfRegistro.rol());
        nuevoUsuario.setFechaRegistro(LocalDateTime.now());

        return usuarioRepository.save(nuevoUsuario);
    }


}
