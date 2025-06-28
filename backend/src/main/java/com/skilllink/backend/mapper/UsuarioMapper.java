package com.skilllink.backend.mapper;

import com.skilllink.backend.dto.usuario.UsuarioInfRegistro;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.enums.RolUsuario;
import com.skilllink.backend.messaging.EmailEventPublisher;
import com.skilllink.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UsuarioMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailEventPublisher emailEventPublisher;

    public Usuario toEntity(UsuarioInfRegistro dto) {
        // Encriptar la contraseña
        String contrasenaEncriptada = passwordEncoder.encode(dto.contrasena());

        // Crear objeto Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setEmail(dto.email());
        nuevoUsuario.setNombre(dto.nombre());
        nuevoUsuario.setNickname(dto.nickname());
        nuevoUsuario.setRol(RolUsuario.valueOf(dto.rol()));
        nuevoUsuario.setContrasena(contrasenaEncriptada);
        nuevoUsuario.setFechaRegistro(LocalDateTime.now());

        // Guardar usuario en la base de datos
        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);

        // Enviar evento para email
        emailEventPublisher.sendUserRegistrationEvent(
            usuarioGuardado.getNombre(),
            usuarioGuardado.getEmail()
        );

        return usuarioGuardado;
    }
}
