package com.skilllink.backend.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioInfRegistro(

        @NotBlank(message = "Ingresa tu nombre completo")
        String nombre,

        @NotBlank(message = "Ingresa tu correo electronico")
        String email,

        @NotBlank(message = "Ingresa una contraseña")
        String contrasena,

        @NotBlank(message = "Selecciona tu rol")
        String rol,

        @NotBlank
        String nickname
        ) {

}
