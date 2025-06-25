package com.skilllink.backend.controller;

import com.skilllink.backend.dto.perfilHabilidad.ActualziarPerfilHabilidad;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesPerfil;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesSeleccionadas;
import com.skilllink.backend.entity.PerfilHabilidad;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.service.ServicioDePerfilHabilidad;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class PerfilHabilidadController {

    @Autowired
    ServicioDePerfilHabilidad servicioDePerfilHabilidad;

    @PostMapping("/agregar")
    public ResponseEntity<List<HabilidadesSeleccionadas>> agregarHabilidad (@RequestBody @Valid List<HabilidadesSeleccionadas> habilidadesNuevas,
                                                                            @AuthenticationPrincipal Usuario usuario){

        List<HabilidadesSeleccionadas> habilidadesSeleccionadas = servicioDePerfilHabilidad.agregarHabilidad(habilidadesNuevas, usuario);
        return ResponseEntity.ok(habilidadesNuevas);

    }

    @DeleteMapping("/borrar/{idHabilidad}")
    public ResponseEntity<Void> eliminarHabilidad(@PathVariable Long idHabilidad, @AuthenticationPrincipal Usuario usuario){
        servicioDePerfilHabilidad.eliminarHabilidad(idHabilidad, usuario);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar")
    public ResponseEntity<HabilidadesPerfil> actualizarHabilidad (@RequestBody ActualziarPerfilHabilidad dto,
                                                                  @AuthenticationPrincipal Usuario usuario){

         PerfilHabilidad perfilHabilidad = servicioDePerfilHabilidad.actualizarUsuario(dto, usuario);
         HabilidadesPerfil habilidadesPerfil = new HabilidadesPerfil(
                 perfilHabilidad.getHabilidad().getIdHabilidad(),
                 perfilHabilidad.getHabilidad().getNombre(), perfilHabilidad.getNivel(),
                 perfilHabilidad.getAnosExperiencia());

         return ResponseEntity.ok(habilidadesPerfil);
    }



}
