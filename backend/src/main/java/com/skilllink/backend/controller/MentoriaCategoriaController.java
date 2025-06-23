package com.skilllink.backend.controller;

import com.skilllink.backend.entity.Categoria;
import com.skilllink.backend.entity.Mentoria;
import com.skilllink.backend.dto.mentoriaCategoria.DatosEntradaMentoriaCategoria;
import com.skilllink.backend.dto.mentoriaCategoria.DatosSalidaMentoriaCategoria;
import com.skilllink.backend.entity.MentoriaCategoria;
import com.skilllink.backend.repository.CategoriaRepository;
import com.skilllink.backend.repository.MentoriaCategoriaRepository;
import com.skilllink.backend.repository.MentoriaRepository;
import com.skilllink.backend.service.MentoriaCategoriaService;
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
@RequestMapping("/mentoria-categoria")
public class MentoriaCategoriaController {

    @Autowired
    private MentoriaCategoriaRepository mentoriaCategoriaRepository;

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private MentoriaCategoriaService service;

    @PostMapping
    public ResponseEntity<DatosSalidaMentoriaCategoria> registrarMentoriaCategoria(
            @RequestBody @Valid DatosEntradaMentoriaCategoria datosEntradaMentoriaCategoria,
            UriComponentsBuilder uriComponentsBuilder) {
        if (mentoriaRepository.existsById(datosEntradaMentoriaCategoria.idMentoria()) && categoriaRepository.existsById(datosEntradaMentoriaCategoria.idCategoria())) {
            Mentoria mentoria = mentoriaRepository.getReferenceById(datosEntradaMentoriaCategoria.idMentoria());
            Categoria categoria = categoriaRepository.getReferenceById(datosEntradaMentoriaCategoria.idCategoria());
            MentoriaCategoria mentoriaCategoria = mentoriaCategoriaRepository.save(new MentoriaCategoria(mentoria, categoria));
            DatosSalidaMentoriaCategoria datosSalidaMentoriaCategoria = new DatosSalidaMentoriaCategoria(mentoriaCategoria);
            URI url = uriComponentsBuilder.path("mentoria-categoria/{id}")
                    .buildAndExpand(mentoriaCategoria.getIdMentoriaCategoria())
                    .toUri();
            return ResponseEntity.created(url).body(datosSalidaMentoriaCategoria);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<DatosSalidaMentoriaCategoria>> listadoMentoriaCategorias(Pageable paginacion) {
        return ResponseEntity.ok(mentoriaCategoriaRepository.findAll(paginacion).map(DatosSalidaMentoriaCategoria::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosSalidaMentoriaCategoria> retornarDatosMentoriaCategoria(@PathVariable Long id) {
        if (mentoriaCategoriaRepository.existsById(id)) {
            MentoriaCategoria mentoriaCategoria = mentoriaCategoriaRepository.getReferenceById(id);
            var datosMentoriaCategoria = new DatosSalidaMentoriaCategoria(mentoriaCategoria);
            return ResponseEntity.ok(datosMentoriaCategoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosSalidaMentoriaCategoria> actualizarMentoriaCategoria(
            @PathVariable Long id,
            @RequestBody @Valid DatosEntradaMentoriaCategoria datosEntradaMentoriaCategoria) {

        if (mentoriaCategoriaRepository.existsById(id) && mentoriaRepository.existsById(datosEntradaMentoriaCategoria.idMentoria()) && categoriaRepository.existsById(datosEntradaMentoriaCategoria.idCategoria())) {
            MentoriaCategoria mentoriaCategoriaActualizada = service.actualizar(id, datosEntradaMentoriaCategoria);
            return ResponseEntity.ok(new DatosSalidaMentoriaCategoria(mentoriaCategoriaActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarMentoriaCategoria(@PathVariable Long id) {
        if (mentoriaCategoriaRepository.existsById(id)) {
            mentoriaCategoriaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

