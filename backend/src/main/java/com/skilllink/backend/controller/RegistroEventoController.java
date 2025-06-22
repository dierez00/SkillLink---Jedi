package com.skilllink.backend.controller;

import com.skilllink.backend.entity.Evento;
import com.skilllink.backend.entity.registroEvento.*;
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
@RequestMapping("/registro-evento")
public class RegistroEventoController {

    @Autowired
    private RegistroEventoRepository registroEventoRepository;

    @Autowired
    private VerificarExistenciaService service;

    @PostMapping
    public ResponseEntity<DatosRespuestaRegistroEvento> registrarRegistroEvento(@RequestBody @Valid DatosRegistroRegistroEvento datosRegistroEvento, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = service.hayUsuario(datosRegistroEvento.idUsuario());
        Evento evento = service.hayEvento(datosRegistroEvento.idEvento());
        RegistroEvento registroEvento = registroEventoRepository.save(new RegistroEvento(datosRegistroEvento, usuario, evento));
        DatosRespuestaRegistroEvento datosRespuestaRegistroEvento = new DatosRespuestaRegistroEvento(registroEvento);
        URI url = uriComponentsBuilder.path("registro/{id}").buildAndExpand(registroEvento.getIdRegistro()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaRegistroEvento);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaRegistroEvento>> listadoRegistroEventos(Pageable paginacion) {
        return ResponseEntity.ok(registroEventoRepository.findAll(paginacion).map(DatosRespuestaRegistroEvento::new));
    }
}
