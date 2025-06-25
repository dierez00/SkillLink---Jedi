package com.skilllink.backend.controller;


import com.skilllink.backend.dto.habilidad.NuevaHabilidadDTO;
import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.dto.habilidad.HabilidadDTO;
import com.skilllink.backend.repository.HabilidadRepositorio;
import com.skilllink.backend.service.ServicioDeHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadController {

    @Autowired
    HabilidadRepositorio habilidadRepositorio;
    @Autowired
    ServicioDeHabilidad servicioDeHabilidad;

    @GetMapping
    public ResponseEntity<List<HabilidadDTO>> obtenerListadoHabilidades() {
        List<Habilidad> habilidades = habilidadRepositorio.findAll();

        List<HabilidadDTO> habilidadDTOS = habilidades.stream()
                .map(habilidad -> new HabilidadDTO(habilidad.getIdHabilidad(),
                        habilidad.getNombre(), habilidad.getCategoria())).toList();

        return ResponseEntity.ok(habilidadDTOS);
    }

    @PostMapping
    public ResponseEntity<HabilidadDTO> agregarHabilidades(@RequestBody NuevaHabilidadDTO nuevaHabilidadDTO){

        Habilidad habilidad  = servicioDeHabilidad.agregarHabilidad(nuevaHabilidadDTO);
        HabilidadDTO habilidadDTO = new HabilidadDTO(habilidad.getIdHabilidad(), habilidad.getNombre(), habilidad.getCategoria());
        return ResponseEntity.ok(habilidadDTO);
    }
}
