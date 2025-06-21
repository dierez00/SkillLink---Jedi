package com.skilllink.backend.entity.categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Categoria")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Column(name = "id_categoria")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String nombre;
    private String descripcion;

    public Categoria(DatosRegistroCategoria datosRegistroCategoria) {
        this.nombre = datosRegistroCategoria.nombre();
        this.descripcion = datosRegistroCategoria.descripcion();
    }
}
