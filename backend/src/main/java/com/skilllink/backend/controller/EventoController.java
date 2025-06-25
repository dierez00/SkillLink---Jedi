package com.skilllink.backend.controller;

import com.skilllink.backend.dto.evento.DatosEntradaEvento;
import com.skilllink.backend.dto.evento.DatosSalidaEvento;
import com.skilllink.backend.entity.Evento;
import com.skilllink.backend.repository.EventoRepository;
import com.skilllink.backend.service.EventoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoService service;

    @PostMapping
    public ResponseEntity<DatosSalidaEvento> registrarEvento(@RequestBody @Valid DatosEntradaEvento datosEntradaEvento, UriComponentsBuilder uriComponentsBuilder) {
        Evento evento = eventoRepository.save(new Evento(datosEntradaEvento));
        DatosSalidaEvento datosSalidaEvento = new DatosSalidaEvento(evento);
        URI url = uriComponentsBuilder.path("evento/{id}").buildAndExpand(evento.getIdEvento()).toUri();
        return ResponseEntity.created(url).body(datosSalidaEvento);
    }

    @GetMapping
    public ResponseEntity<Page<DatosSalidaEvento>> listadoEventos(Pageable paginacion) {
        return ResponseEntity.ok(eventoRepository.findAll(paginacion).map(DatosSalidaEvento::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosSalidaEvento> retornarDatosEvento(@PathVariable Long id) {
        if (eventoRepository.existsById(id)) {
            Evento evento = eventoRepository.getReferenceById(id);
            var datosEvento = new DatosSalidaEvento(evento);
            return ResponseEntity.ok(datosEvento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosSalidaEvento> actualizarEvento(@PathVariable Long id, @RequestBody @Valid DatosEntradaEvento datosEntradaEvento) {
        if (eventoRepository.existsById(id)) {
            Evento eventoActualizado = service.actualizar(id, datosEntradaEvento);
            return ResponseEntity.ok(new DatosSalidaEvento(eventoActualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarEvento(@PathVariable Long id) {
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DatosSalidaEvento>> buscarEventosPorHabilidad(@RequestParam String habilidad) {
        List<DatosSalidaEvento> resultados = service.buscarEventosPorHabilidad(habilidad);
        return ResponseEntity.ok(resultados);
    }
}
