package com.skilllink.backend.entity.categoria;

public record DatosRespuestaCategoria(
        Long idCategoria,
        String nombre,
        String descripcion) {

    public DatosRespuestaCategoria(Categoria categoria) {
        this(categoria.getIdCategoria(),
                categoria.getNombre(),
                categoria.getDescripcion());
    }
}
