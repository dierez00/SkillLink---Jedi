package com.skilllink.backend.dto.categoria;

import com.skilllink.backend.entity.Categoria;

public record DatosSalidaCategoria(
        Long idCategoria,
        String nombre,
        String descripcion) {

    public DatosSalidaCategoria(Categoria categoria) {
        this(categoria.getIdCategoria(),
                categoria.getNombre(),
                categoria.getDescripcion());
    }
}
