package com.skilllink.backend.entity.mentoria;

import com.skilllink.backend.entity.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Mentoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mentoria {
    @Column(name = "id_mentoria")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMentoria;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String titulo;
    private String descripcion;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    private String estado;

    public Mentoria(DatosRegistroMentoria datosRegistroMentoria, Usuario usuario) {
        this.usuario = usuario;
        this.titulo = datosRegistroMentoria.titulo();
        this.descripcion = datosRegistroMentoria.descripcion();
        this.fechaPublicacion = datosRegistroMentoria.fechaPublicacion();
        this.estado = datosRegistroMentoria.estado();
    }
}
