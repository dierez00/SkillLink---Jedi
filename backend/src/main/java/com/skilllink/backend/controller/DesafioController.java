package com.skilllink.backend.controller;

import com.skilllink.backend.entity.Desafio;
import com.skilllink.backend.service.DesafioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desafios")
@CrossOrigin(origins = "*")
public class DesafioController {

    @Autowired
    private DesafioService service;

    @GetMapping
    public List<Desafio> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desafio> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Desafio create(@RequestBody Desafio desafio) {
        return service.create(desafio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Desafio> update(@PathVariable Long id, @RequestBody Desafio desafio) {
        Desafio updated = service.update(id, desafio);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Desafio>> getDesafiosByHabilidad(@RequestParam String habilidad) {
        List<Desafio> resultados = service.findDesafiosByHabilidad(habilidad);
        return ResponseEntity.ok(resultados);
    }

}
