package com.skilllink.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Habilidad")
@Entity(name = "Habilidad")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_habilidad")
    private Long idHabilidad;
    private String nombre;
    private String categoria;

    @OneToMany (mappedBy = "habilidad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PerfilHabilidad> perfilHabilidades = new ArrayList<>();

}
