package com.skilllink.backend.mapper;

import com.skilllink.backend.dto.usuario.UsuarioInfRegistro;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.enums.RolUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UsuarioMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario toEntity(UsuarioInfRegistro dto){

        String contrasenaEncriptada = passwordEncoder.encode(dto.contrasena());

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.email());
        usuario.setNombre(dto.nombre());
        usuario.setNickname(dto.nickname());
        usuario.setRol(RolUsuario.valueOf(dto.rol()));
        usuario.setContrasena(contrasenaEncriptada);
        usuario.setFechaRegistro(LocalDateTime.now());
        return usuario;
    }


}
