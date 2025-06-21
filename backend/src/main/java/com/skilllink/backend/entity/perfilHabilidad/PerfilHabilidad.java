package com.skilllink.backend.entity.perfilHabilidad;

import com.skilllink.backend.entity.habilidad.Habilidad;
import com.skilllink.backend.entity.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfil_habilidad")
@Entity(name = "PerfilHabilidad")
@EqualsAndHashCode (of = "idPerfilHabilidad")
public class PerfilHabilidad {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_perfil_habilidad")
    private Long idPerfilHabilidad;

    private String nivel;
    @Column (name = "años_experiencia")
    private int anosExperiencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_habilidad")
    private Habilidad habilidad;
}
