package com.skilllink.backend.entity;

import com.skilllink.backend.dto.categoria.DatosEntradaCategoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Column(name = "id_categoria")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String nombre;
    private String descripcion;

    public Categoria(DatosEntradaCategoria datosEntradaCategoria) {
        this.nombre = datosEntradaCategoria.nombre();
        this.descripcion = datosEntradaCategoria.descripcion();
    }
}
