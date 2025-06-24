package com.skilllink.backend.controller;


import com.skilllink.backend.entity.habilidad.Habilidad;
import com.skilllink.backend.dto.habilidad.HabilidadDTO;
import com.skilllink.backend.repository.HabilidadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {

    @Autowired
    HabilidadRepositorio habilidadRepositorio;

    @GetMapping
    public ResponseEntity<List<HabilidadDTO>> obtenerListadoHabilidades() {
        List<Habilidad> habilidades = habilidadRepositorio.findAll();

        List<HabilidadDTO> habilidadDTOS = habilidades.stream()
                .map(habilidad -> new HabilidadDTO(habilidad.getIdHabilidad(),
                        habilidad.getNombre(), habilidad.getCategoria())).toList();

        return ResponseEntity.ok(habilidadDTOS);
    }
}
