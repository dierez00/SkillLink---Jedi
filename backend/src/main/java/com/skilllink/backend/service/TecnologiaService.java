package com.skilllink.backend.service;

import com.skilllink.backend.entity.Tecnologia;
import com.skilllink.backend.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnologiaService {

    @Autowired
    private TecnologiaRepository repository;

    public List<Tecnologia> getAll() {
        return repository.findAll();
    }

    public Optional<Tecnologia> getById(Long id) {
        return repository.findById(id);
    }

    public Tecnologia create(Tecnologia tecnologia) {
        return repository.save(tecnologia);
    }

    public Tecnologia update(Long id, Tecnologia nuevaTecnologia) {
        return repository.findById(id).map(existing -> {
            existing.setNombre(nuevaTecnologia.getNombre());
            existing.setTipo(nuevaTecnologia.getTipo());
            return repository.save(existing);
        }).orElse(null);
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
