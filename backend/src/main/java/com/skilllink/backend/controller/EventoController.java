package com.skilllink.backend.controller;

import com.skilllink.backend.entity.evento.*;
import com.skilllink.backend.entity.registroEvento.DatosRegistroRegistroEvento;
import com.skilllink.backend.entity.registroEvento.DatosRespuestaRegistroEvento;
import com.skilllink.backend.entity.registroEvento.RegistroEvento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/hello")
    public String mensaje() {
        return "Hola mundo!";
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaEvento> registrarEvento(@RequestBody @Valid DatosRegistroEvento datosRegistroEvento, UriComponentsBuilder uriComponentsBuilder) {
        Evento evento = eventoRepository.save(new Evento(datosRegistroEvento));
        DatosRespuestaEvento datosRespuestaEvento = new DatosRespuestaEvento(evento.getIdEvento(), evento.getTitulo(), evento.getDescripcion(), evento.getUbicacion(), evento.getFechaEvento(), evento.getOrganizador());
        URI url = uriComponentsBuilder.path("evento/{id}").buildAndExpand(evento.getIdEvento()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaEvento);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoEvento>> listadoEventos(Pageable paginacion) {
        return ResponseEntity.ok(eventoRepository.findAll(paginacion).map(DatosListadoEvento::new));
    }
}
