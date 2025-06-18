package com.skilllink.backend.entity.Usuario;

import java.time.LocalDateTime;

public record UsuarioInfRegistro(Long idUsuario, String nombre, String email, String contrasena, String rol, LocalDateTime fechaDeRegistro) {

}
