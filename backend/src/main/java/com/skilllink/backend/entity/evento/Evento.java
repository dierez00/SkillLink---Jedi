package com.skilllink.backend.entity.evento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity //uses class name as entity name, else specify with e.g. (name = "Evento")
@Table(name = "Evento") //specifies db table name, else defaults to lower case class name
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @Column(name = "id_evento")
    @Id
    //allows to use method repository.save() with automatically generated ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    @Column(name = "fecha_evento")
    private LocalDateTime fechaEvento;
    private String organizador;

    public Evento(DatosRegistroEvento datosRegistroEvento) {
        this.titulo = datosRegistroEvento.titulo();
        this.descripcion = datosRegistroEvento.descripcion();
        this.ubicacion = datosRegistroEvento.ubicacion();
        this.fechaEvento = datosRegistroEvento.fechaEvento();
        this.organizador = datosRegistroEvento.organizador();
    }
}

