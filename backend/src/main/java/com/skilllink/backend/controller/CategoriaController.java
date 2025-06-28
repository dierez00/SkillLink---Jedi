package com.skilllink.backend.controller;

import com.skilllink.backend.entity.Categoria;
import com.skilllink.backend.repository.CategoriaRepository;
import com.skilllink.backend.dto.categoria.DatosEntradaCategoria;
import com.skilllink.backend.dto.categoria.DatosSalidaCategoria;
import com.skilllink.backend.service.CategoriaService;
import jakarta.transaction.Transactional;
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
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<DatosSalidaCategoria> registrarCategoria(@RequestBody @Valid DatosEntradaCategoria datosRegistroCategoria, UriComponentsBuilder uriComponentsBuilder) {
        Categoria categoria = categoriaRepository.save(new Categoria(datosRegistroCategoria));
        DatosSalidaCategoria datosRespuestaCategoria = new DatosSalidaCategoria(categoria);
        URI url = uriComponentsBuilder.path("categoria/{id}").buildAndExpand(categoria.getIdCategoria()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCategoria);
    }

    @GetMapping("/obtener")
    public ResponseEntity<Page<DatosSalidaCategoria>> listadoCategorias(Pageable paginacion) {
        return ResponseEntity.ok(categoriaRepository.findAll(paginacion).map(DatosSalidaCategoria::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosSalidaCategoria> retornarDatosCategoria(@PathVariable Long id) {
        if (categoriaRepository.existsById(id)) {
            Categoria categoria = categoriaRepository.getReferenceById(id);
            var datosCategoria = new DatosSalidaCategoria(categoria);
            return ResponseEntity.ok(datosCategoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosSalidaCategoria> actualizarCategoria(@PathVariable Long id, @RequestBody @Valid DatosEntradaCategoria datosEntradaCategoria) {
        if (categoriaRepository.existsById(id)) {
            Categoria categoriaActualizada = service.actualizar(id, datosEntradaCategoria);
            return ResponseEntity.ok(new DatosSalidaCategoria(categoriaActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
