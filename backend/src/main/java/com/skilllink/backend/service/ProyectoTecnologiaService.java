package com.skilllink.backend.service;

import com.skilllink.backend.entity.Proyecto;
import com.skilllink.backend.entity.Tecnologia;
import com.skilllink.backend.entity.ProyectoTecnologia;
import com.skilllink.backend.repository.ProyectoRepository;
import com.skilllink.backend.repository.TecnologiaRepository;
import com.skilllink.backend.repository.ProyectoTecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoTecnologiaService {

    @Autowired
    private ProyectoTecnologiaRepository proyectoTecnologiaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    public List<ProyectoTecnologia> getAll() {
        return proyectoTecnologiaRepository.findAll();
    }

    public Optional<ProyectoTecnologia> getById(Long id) {
        return proyectoTecnologiaRepository.findById(id);
    }

    public ProyectoTecnologia create(ProyectoTecnologia relacion) {
        Optional<Proyecto> proyecto = proyectoRepository.findById(relacion.getId_proyecto());
        Optional<Tecnologia> tecnologia = tecnologiaRepository.findById(relacion.getId_tecnologia());

        if (proyecto.isPresent() && tecnologia.isPresent()) {
            return proyectoTecnologiaRepository.save(relacion);
        }

        // Lanza excepción si alguno no existe
        throw new IllegalArgumentException("El proyecto o la tecnología no existen.");
    }

    public boolean delete(Long id) {
        if (proyectoTecnologiaRepository.existsById(id)) {
            proyectoTecnologiaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
