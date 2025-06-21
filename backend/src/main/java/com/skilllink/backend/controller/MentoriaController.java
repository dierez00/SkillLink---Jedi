package com.skilllink.backend.controller;

import com.skilllink.backend.entity.mentoria.DatosRegistroMentoria;
import com.skilllink.backend.entity.mentoria.DatosRespuestaMentoria;
import com.skilllink.backend.entity.mentoria.Mentoria;
import com.skilllink.backend.entity.mentoria.MentoriaRepository;
import com.skilllink.backend.entity.usuario.Usuario;
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
@RequestMapping("/mentoria")
public class MentoriaController {

    @Autowired
    MentoriaRepository mentoriaRepository;

    @Autowired
    VerificarExistenciaService service;

    @PostMapping
    public ResponseEntity<DatosRespuestaMentoria> registrarMentoria(@RequestBody @Valid DatosRegistroMentoria datosRegistroMentoria, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = service.hayUsuario(datosRegistroMentoria.idUsuario());
        Mentoria mentoria = mentoriaRepository.save(new Mentoria(datosRegistroMentoria, usuario));
        DatosRespuestaMentoria datosRespuestaMentoria = new DatosRespuestaMentoria(mentoria);
        URI url = uriComponentsBuilder.path("mentoria/{id}").buildAndExpand(mentoria.getIdMentoria()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaMentoria);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaMentoria>> listadoMentorias(Pageable paginacion) {
        return ResponseEntity.ok(mentoriaRepository.findAll(paginacion).map(DatosRespuestaMentoria::new));
    }
}
