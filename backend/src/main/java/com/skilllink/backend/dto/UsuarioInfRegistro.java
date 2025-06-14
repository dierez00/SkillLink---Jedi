package com.skilllink.backend.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record UsuarioInfRegistro(Long idUsuario, String nombre, String email, String contrasena, String rol, LocalDateTime fechaDeRegistro) {

}
