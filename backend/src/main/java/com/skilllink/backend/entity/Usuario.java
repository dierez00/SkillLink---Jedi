package com.skilllink.backend.entity;

import com.skilllink.backend.dto.UsuarioInfRegistro;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class Usuario {
    private Long idUsuario;
    private String nombre;
    private String email;
    private String contrasena;
    private String rol;
    private LocalDateTime fechaRegistro;

    public Usuario (UsuarioInfRegistro usuarioInfRegistro){
        this.idUsuario = usuarioInfRegistro.idUsuario();
        this.nombre = usuarioInfRegistro.nombre();
        this.email = usuarioInfRegistro.email();
        this.contrasena = usuarioInfRegistro.email();
        this.rol = usuarioInfRegistro.rol();
        this.fechaRegistro = LocalDateTime.now();
    }

}



