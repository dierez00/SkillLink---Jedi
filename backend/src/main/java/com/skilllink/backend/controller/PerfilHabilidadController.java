package com.skilllink.backend.controller;

import com.skilllink.backend.dto.perfilHabilidad.ActualziarHabilidad;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesPerfil;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesSeleccionadas;
import com.skilllink.backend.dto.perfilHabilidad.NivelDTO;
import com.skilllink.backend.entity.PerfilHabilidad;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.enums.NivelHabilidad;
import com.skilllink.backend.service.PerfilHabilidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class PerfilHabilidadController {

    @Autowired
    PerfilHabilidadService perfilHabilidadService;


    @GetMapping("/niveles")
    public ResponseEntity<List<NivelDTO>> obtenerNiveles (){

        List<NivelDTO> nivelDTOS = Arrays.stream(NivelHabilidad.values()).map(
                nivel -> new NivelDTO(nivel.name(), nivel.getRolVisible())
        ).toList();
        return ResponseEntity.ok(nivelDTOS);
    }

    @PostMapping("/agregar")
    public ResponseEntity<List<HabilidadesSeleccionadas>> agregarHabilidad (@RequestBody @Valid List<HabilidadesSeleccionadas> habilidadesNuevas,
                                                                            @AuthenticationPrincipal Usuario usuario){

        List<HabilidadesSeleccionadas> habilidadesSeleccionadas = perfilHabilidadService.agregarHabilidad(habilidadesNuevas, usuario);
        return ResponseEntity.ok(habilidadesSeleccionadas);

    }

    @DeleteMapping("/borrar/{idHabilidad}")
    public ResponseEntity<Void> eliminarHabilidad(@PathVariable Long idHabilidad, @AuthenticationPrincipal Usuario usuario){
        perfilHabilidadService.eliminarHabilidad(idHabilidad, usuario);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar")
    public ResponseEntity<HabilidadesPerfil> actualizarHabilidad (@RequestBody ActualziarHabilidad dto,
                                                                  @AuthenticationPrincipal Usuario usuario){

         PerfilHabilidad ph = perfilHabilidadService.actualizarUsuario(dto, usuario);
         HabilidadesPerfil habilidadesPerfil = new HabilidadesPerfil(
                 ph.getHabilidad().getIdHabilidad(),
                 ph.getHabilidad().getNombre(), String.valueOf(ph.getNivel()),
                 ph.getAnosExperiencia());

         return ResponseEntity.ok(habilidadesPerfil);
    }


}
