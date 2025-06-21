package com.skilllink.backend.controller;

import com.skilllink.backend.entity.categoria.Categoria;
import com.skilllink.backend.entity.mentoria.Mentoria;
import com.skilllink.backend.entity.mentoriaCategoria.DatosRegistroMentoriaCategoria;
import com.skilllink.backend.entity.mentoriaCategoria.DatosRespuestaMentoriaCategoria;
import com.skilllink.backend.entity.mentoriaCategoria.MentoriaCategoria;
import com.skilllink.backend.entity.mentoriaCategoria.MentoriaCategoriaRepository;
import com.skilllink.backend.service.VerificarExistenciaService;
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
    MentoriaCategoriaRepository mentoriaCategoriaRepository;

    @Autowired
    VerificarExistenciaService service;

    @PostMapping
    public ResponseEntity<DatosRespuestaMentoriaCategoria> registrarMentoriaCategoria(
            @RequestBody @Valid DatosRegistroMentoriaCategoria datosRegistroMentoriaCategoria,
            UriComponentsBuilder uriComponentsBuilder) {

        Mentoria mentoria = service.hayMentoria(datosRegistroMentoriaCategoria.idMentoria());
        Categoria categoria = service.hayCategoria(datosRegistroMentoriaCategoria.idCategoria());
        MentoriaCategoria mentoriaCategoria = mentoriaCategoriaRepository.save(new MentoriaCategoria(mentoria, categoria));
        DatosRespuestaMentoriaCategoria datosRespuestaMentoriaCategoria = new DatosRespuestaMentoriaCategoria(mentoriaCategoria);
        URI url = uriComponentsBuilder.path("mentoria-categoria/{id}")
                .buildAndExpand(mentoriaCategoria.getIdMentoriaCategoria())
                .toUri();
        return ResponseEntity.created(url).body(datosRespuestaMentoriaCategoria);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaMentoriaCategoria>> listadoMentoriaCategorias(Pageable paginacion) {
        return ResponseEntity.ok(mentoriaCategoriaRepository.findAll(paginacion).map(DatosRespuestaMentoriaCategoria::new));
    }
}

