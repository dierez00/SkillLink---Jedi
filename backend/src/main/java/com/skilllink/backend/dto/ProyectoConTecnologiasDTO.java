package com.skilllink.backend.dto;

import com.skilllink.backend.entity.Tecnologia;

import java.time.LocalDateTime;
import java.util.List;

public class ProyectoConTecnologiasDTO {
    private Long id_proyecto;
    private String titulo;
    private String descripcion;
    private String estado;
    private LocalDateTime fecha_inicio;
    private List<Tecnologia> tecnologias;

    // Constructor completo
    public ProyectoConTecnologiasDTO(Long id_proyecto, String titulo, String descripcion, String estado, LocalDateTime fecha_inicio, List<Tecnologia> tecnologias) {
        this.id_proyecto = id_proyecto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha_inicio = fecha_inicio;
        this.tecnologias = tecnologias;
    }

    // Getters
    public Long getId_proyecto() { return id_proyecto; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    public LocalDateTime getFecha_inicio() { return fecha_inicio; }
    public List<Tecnologia> getTecnologias() { return tecnologias; }
}
