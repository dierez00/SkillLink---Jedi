package com.skilllink.backend.entity.usuario;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class Usuario {
    @Column(name = "id_usuario")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombre;
    private String email;
    @Column(name = "contrasea")
    private String contrasena;
    private String rol;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
}
