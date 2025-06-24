package com.skilllink.backend.entity;

import com.skilllink.backend.dto.mentoria.DatosEntradaMentoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Mentoria")
@Getter
@Setter
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

    public Mentoria(DatosEntradaMentoria datosEntradaMentoria, Usuario usuario) {
        this.usuario = usuario;
        this.titulo = datosEntradaMentoria.titulo();
        this.descripcion = datosEntradaMentoria.descripcion();
        this.fechaPublicacion = datosEntradaMentoria.fechaPublicacion();
        this.estado = datosEntradaMentoria.estado();
    }
}
