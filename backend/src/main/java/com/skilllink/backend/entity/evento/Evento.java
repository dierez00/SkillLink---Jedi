package com.skilllink.backend.entity.evento;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity //uses class name as entity name, else specify with e.g. (name = "Evento")
@Table(name = "Evento") //specifies db table name, else defaults to lower case class name
@Getter
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


}

