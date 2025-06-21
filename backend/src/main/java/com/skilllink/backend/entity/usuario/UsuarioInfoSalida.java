package com.skilllink.backend.entity.usuario;

import java.time.LocalDateTime;

public record UsuarioInfoSalida(Long idUsuario, String nombre, String email, LocalDateTime fechaRegistro) {
}
