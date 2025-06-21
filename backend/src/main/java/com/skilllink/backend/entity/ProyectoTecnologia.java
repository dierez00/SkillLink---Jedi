package com.skilllink.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Proyecto_Tecnologia")
public class ProyectoTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proyecto_tecnologia;

    private Long id_proyecto;
    private Long id_tecnologia;

    // Getters y setters
    public Long getId_proyecto_tecnologia() {
        return id_proyecto_tecnologia;
    }

    public void setId_proyecto_tecnologia(Long id_proyecto_tecnologia) {
        this.id_proyecto_tecnologia = id_proyecto_tecnologia;
    }

    public Long getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Long id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public Long getId_tecnologia() {
        return id_tecnologia;
    }

    public void setId_tecnologia(Long id_tecnologia) {
        this.id_tecnologia = id_tecnologia;
    }
}
