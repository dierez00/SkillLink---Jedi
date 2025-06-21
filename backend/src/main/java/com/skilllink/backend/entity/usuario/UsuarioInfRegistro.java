package com.skilllink.backend.entity.usuario;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UsuarioInfRegistro(

        @NotBlank(message = "Ingresa tu nombre completo")
        String nombre,

        @NotBlank(message = "Ingresa tu correo electronico")
        String email,

        @NotBlank(message = "Ingresa una contraseña")
        String contrasena,

        @NotBlank(message = "Selecciona tu rol")
        String rol
        ) {

}
