package com.skilllink.backend.service;

import com.skilllink.backend.dto.evento.DatosEntradaEvento;
import com.skilllink.backend.dto.evento.DatosSalidaEvento;
import com.skilllink.backend.dto.mentoria.DatosSalidaMentoria;
import com.skilllink.backend.entity.Evento;
import com.skilllink.backend.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento actualizar(Long id, DatosEntradaEvento datosEntradaEvento) {
        Evento evento = eventoRepository.getReferenceById(id);
        evento.setTitulo(datosEntradaEvento.titulo());
        evento.setDescripcion(datosEntradaEvento.descripcion());
        evento.setUbicacion(datosEntradaEvento.ubicacion());
        evento.setFechaEvento(datosEntradaEvento.fechaEvento());
        evento.setOrganizador(datosEntradaEvento.organizador());
        return evento;
    }

    public List<DatosSalidaEvento> buscarEventosPorHabilidad(String habilidad) {
        return eventoRepository.findByHabilidadInDescripcion(habilidad)
                .stream()
                .map(DatosSalidaEvento::new)
                .toList();
    }

}
