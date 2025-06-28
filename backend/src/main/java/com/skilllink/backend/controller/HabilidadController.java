package com.skilllink.backend.controller;


import com.skilllink.backend.dto.habilidad.NuevaHabilidadDTO;
import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.dto.habilidad.HabilidadDTO;
import com.skilllink.backend.repository.HabilidadRepositorio;
import com.skilllink.backend.service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadController {

    @Autowired
    HabilidadRepositorio habilidadRepositorio;
    @Autowired
    HabilidadService habilidadService;

    @GetMapping("/consultar")
    public ResponseEntity<Page<HabilidadDTO>> obtenerListadoHabilidades(@PageableDefault Pageable pageable) {

        Page<Habilidad> listaHabilidades = habilidadService.listadoHabilidades(pageable);
        Page<HabilidadDTO> dto = listaHabilidades.map(lh -> new HabilidadDTO(
                lh.getIdHabilidad(), lh.getNombre(), lh.getCategoria()
        ));

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/agregar")
    public ResponseEntity<HabilidadDTO> agregarHabilidades(@RequestBody NuevaHabilidadDTO nuevaHabilidadDTO){

        Habilidad habilidad  = habilidadService.agregarHabilidad(nuevaHabilidadDTO);
        HabilidadDTO habilidadDTO = new HabilidadDTO(habilidad.getIdHabilidad(), habilidad.getNombre(), habilidad.getCategoria());
        return ResponseEntity.ok(habilidadDTO);
    }

    @DeleteMapping("/eliminar/{idHabilidad}")
    public ResponseEntity<Void> eliminarHabilidad (@PathVariable Long idHabilidad){
        habilidadService.eliminarHabilidad(idHabilidad);
        return ResponseEntity.noContent().build();
    }

}
