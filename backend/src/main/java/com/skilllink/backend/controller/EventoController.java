package com.skilllink.backend.controller;

import com.skilllink.backend.entity.evento.DatosListadoEvento;
import com.skilllink.backend.entity.evento.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/hello")
    public String mensaje() {
        return "Hola mundo!";
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoEvento>> listadoEventos(Pageable paginacion) {
        return ResponseEntity.ok(eventoRepository.findAll(paginacion).map(DatosListadoEvento::new));
    }
}
