package com.skilllink.backend.controller;

import com.skilllink.backend.entity.Proyecto;
import com.skilllink.backend.service.ProyectoService;
import com.skilllink.backend.dto.ProyectoConTecnologiasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = "*")
public class ProyectoController {

    @Autowired
    private ProyectoService service;

    @GetMapping
    public List<Proyecto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proyecto create(@RequestBody Proyecto proyecto) {
        return service.create(proyecto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> update(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        Proyecto updated = service.update(id, proyecto);
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
    @GetMapping("/{id}/tecnologias")
    public ResponseEntity<ProyectoConTecnologiasDTO> getProyectoConTecnologias(@PathVariable Long id) {
        try {
            ProyectoConTecnologiasDTO dto = service.getProyectoConTecnologias(id);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Proyecto>> getProyectosByHabilidad(@RequestParam String habilidad) {
        List<Proyecto> resultados = service.findProyectosByHabilidad(habilidad);
        return ResponseEntity.ok(resultados);
    }

}
