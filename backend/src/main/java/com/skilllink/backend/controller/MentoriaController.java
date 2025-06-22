package com.skilllink.backend.controller;

import com.skilllink.backend.dto.mentoria.DatosEntradaMentoria;
import com.skilllink.backend.dto.mentoria.DatosSalidaMentoria;
import com.skilllink.backend.entity.Mentoria;
import com.skilllink.backend.entity.usuario.UsuarioRepository;
import com.skilllink.backend.repository.MentoriaRepository;
import com.skilllink.backend.entity.usuario.Usuario;
import com.skilllink.backend.service.MentoriaService;
import com.skilllink.backend.service.VerificarExistenciaService;
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
@RequestMapping("/mentoria")
public class MentoriaController {

    @Autowired
    private MentoriaRepository mentoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VerificarExistenciaService service1;

    @Autowired
    private MentoriaService service;

    @PostMapping
    public ResponseEntity<DatosSalidaMentoria> registrarMentoria(@RequestBody @Valid DatosEntradaMentoria datosEntradaMentoria, UriComponentsBuilder uriComponentsBuilder) {
        if (usuarioRepository.existsById(datosEntradaMentoria.idUsuario())) {
            Usuario usuario = usuarioRepository.getReferenceById(datosEntradaMentoria.idUsuario());
            Mentoria mentoria = mentoriaRepository.save(new Mentoria(datosEntradaMentoria, usuario));
            DatosSalidaMentoria datosSalidaMentoria = new DatosSalidaMentoria(mentoria);
            URI url = uriComponentsBuilder.path("mentoria/{id}").buildAndExpand(mentoria.getIdMentoria()).toUri();
            return ResponseEntity.created(url).body(datosSalidaMentoria);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<DatosSalidaMentoria>> listadoMentorias(Pageable paginacion) {
        return ResponseEntity.ok(mentoriaRepository.findAll(paginacion).map(DatosSalidaMentoria::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosSalidaMentoria> retornarDatosMentoria(@PathVariable Long id) {
        if (mentoriaRepository.existsById(id)) {
            Mentoria mentoria = mentoriaRepository.getReferenceById(id);
            var datosMentoria = new DatosSalidaMentoria(mentoria);
            return ResponseEntity.ok(datosMentoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosSalidaMentoria> actualizarMentoria(@PathVariable Long id, @RequestBody @Valid DatosEntradaMentoria datosEntradaMentoria) {
        if (mentoriaRepository.existsById(id)) {
            Mentoria mentoriaActualizada = service.actualizar(id, datosEntradaMentoria);
            return ResponseEntity.ok(new DatosSalidaMentoria(mentoriaActualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarMentoria(@PathVariable Long id) {
        if (mentoriaRepository.existsById(id)) {
            mentoriaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
