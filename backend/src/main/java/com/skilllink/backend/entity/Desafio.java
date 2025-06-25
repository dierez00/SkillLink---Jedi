package com.skilllink.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Desafio")
public class Desafio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_desafio;

    private Long id_usuario;
    private String titulo;
    private String descripcion;
    private String dificultad;
    private LocalDateTime fecha_limite;
    private String estado;

    // Getters y Setters
    public Long getid_desafio() { return id_desafio; }
    public void setid_desafio(Long id_desafio) { this.id_desafio = id_desafio; }

    public Long getid_usuario() { return id_usuario; }
    public void setid_usuario(Long id_usuario) { this.id_usuario = id_usuario; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDificultad() { return dificultad; }
    public void setDificultad(String dificultad) { this.dificultad = dificultad; }

    public LocalDateTime getfecha_limite() { return fecha_limite; }
    public void setfecha_limite(LocalDateTime fecha_limite) { this.fecha_limite = fecha_limite; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
