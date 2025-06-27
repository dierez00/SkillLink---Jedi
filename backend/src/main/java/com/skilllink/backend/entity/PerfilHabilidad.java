package com.skilllink.backend.entity;

import com.skilllink.backend.enums.NivelHabilidad;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Perfil_Habilidad")
@Entity(name = "PerfilHabilidad")
@EqualsAndHashCode (of = "idPerfilHabilidad")
public class PerfilHabilidad {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_perfil_habilidad")
    private Long idPerfilHabilidad;

    @Enumerated(EnumType.STRING)
    private NivelHabilidad nivel;
    @Column (name = "aos_experiencia")
    private int anosExperiencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_habilidad")
    private Habilidad habilidad;

}
