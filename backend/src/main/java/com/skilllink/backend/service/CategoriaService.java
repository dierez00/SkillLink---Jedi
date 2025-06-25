package com.skilllink.backend.service;

import com.skilllink.backend.dto.categoria.DatosEntradaCategoria;
import com.skilllink.backend.entity.Categoria;
import com.skilllink.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria actualizar(Long id, DatosEntradaCategoria datosEntradaCategoria) {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        categoria.setNombre(datosEntradaCategoria.nombre());
        categoria.setDescripcion(datosEntradaCategoria.descripcion());
        return categoria;
    }
}
