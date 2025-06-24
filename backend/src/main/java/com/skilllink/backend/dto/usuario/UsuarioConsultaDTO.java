package com.skilllink.backend.dto.usuario;

import java.time.LocalDateTime;

public record UsuarioConsultaDTO (String nombre, String email, LocalDateTime fechaRegistro) {
}
