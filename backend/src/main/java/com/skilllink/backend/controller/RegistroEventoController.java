package com.skilllink.backend.controller;

import com.skilllink.backend.entity.evento.Evento;
import com.skilllink.backend.entity.registroEvento.*;
import com.skilllink.backend.entity.usuario.Usuario;
import com.skilllink.backend.service.VerificarRegistroEventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/registro")
public class RegistroEventoController {

    @Autowired
    private RegistroEventoRepository registroEventoRepository;

    @Autowired
    private VerificarRegistroEventoService service;

    @PostMapping
    public ResponseEntity<DatosRespuestaRegistroEvento> registrarRegistroEvento(@RequestBody @Valid DatosRegistroRegistroEvento datosRegistroEvento, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = service.hayUsuario(datosRegistroEvento.idUsuario());
        Evento evento = service.hayEvento(datosRegistroEvento.idEvento());
        RegistroEvento registroEvento = registroEventoRepository.save(new RegistroEvento(datosRegistroEvento, usuario, evento));
        DatosRespuestaRegistroEvento datosRespuestaRegistroEvento = new DatosRespuestaRegistroEvento(registroEvento.getIdRegistro(), registroEvento.getUsuario().getIdUsuario(), registroEvento.getEvento().getIdEvento(), registroEvento.getFechaRegistro());
        URI url = uriComponentsBuilder.path("registro/{id}").buildAndExpand(registroEvento.getIdRegistro()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaRegistroEvento);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoRegistroEvento>> listadoRegistroEventos(Pageable paginacion) {
        return ResponseEntity.ok(registroEventoRepository.findAll(paginacion).map(DatosListadoRegistroEvento::new));
    }
}
