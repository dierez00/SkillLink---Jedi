package com.skilllink.backend.controller;

import com.skilllink.backend.entity.categoria.Categoria;
import com.skilllink.backend.entity.categoria.CategoriaRepository;
import com.skilllink.backend.entity.categoria.DatosRegistroCategoria;
import com.skilllink.backend.entity.categoria.DatosRespuestaCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaCategoria> registrarCategoria(@RequestBody @Valid DatosRegistroCategoria datosRegistroCategoria, UriComponentsBuilder uriComponentsBuilder) {
        Categoria categoria = categoriaRepository.save(new Categoria(datosRegistroCategoria));
        DatosRespuestaCategoria datosRespuestaCategoria = new DatosRespuestaCategoria(categoria);
        URI url = uriComponentsBuilder.path("categoria/{id}").buildAndExpand(categoria.getIdCategoria()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCategoria);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaCategoria>> listadoCategorias(Pageable paginacion) {
        return ResponseEntity.ok(categoriaRepository.findAll(paginacion).map(DatosRespuestaCategoria::new));
    }
}
