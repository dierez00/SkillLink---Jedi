package com.skilllink.backend.controller;

import com.skilllink.backend.dto.perfil.ConsultaPerfil;
import com.skilllink.backend.dto.perfil.DatosDeSalidaPerfil;
import com.skilllink.backend.dto.perfil.DatosPerfil;
import com.skilllink.backend.dto.perfil.DatosPerfilActualizado;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesPerfil;
import com.skilllink.backend.entity.Perfil;
import com.skilllink.backend.service.PerfilService;
import com.skilllink.backend.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/perfil")
public class PerfilController {

    @Autowired
    PerfilService perfilService;

    @PostMapping("/crear")
    //La etiqueta @Authentication Principal inyecta al usuario actualmente verifcado al controlador
    public ResponseEntity<DatosDeSalidaPerfil> crearPerfil(@RequestBody @Valid DatosPerfil datosPerfil,
                                                           @AuthenticationPrincipal Usuario usuario,
                                                           UriComponentsBuilder uriComponentsBuilder) {

        Perfil perfil = perfilService.creacionDePerfil(usuario, datosPerfil);

        DatosDeSalidaPerfil datosDeSalidaPerfil = new DatosDeSalidaPerfil(perfil.getUsuario().getNombre(),
                perfil.getDescripcion(), perfil.getExperiencia(), perfil.getUbicacion(), perfil.getRedesSociales(), datosPerfil.habilidades());

        URI url = uriComponentsBuilder.path("/perfil/{id}").buildAndExpand(perfil.getIdPerfil()).toUri();

        return ResponseEntity.created(url).body(datosDeSalidaPerfil);
    }

    @GetMapping("/mi-cuenta")
    public ResponseEntity<ConsultaPerfil> obtenerMiPerfil(@AuthenticationPrincipal Usuario usuario){

        Perfil consultarPerfil = perfilService.consultarPerfil(usuario.getPerfil().getIdPerfil());

        List<HabilidadesPerfil> habilidadDTO = consultarPerfil.getPerfilHabilidad()
                .stream().map(
                        ph -> new HabilidadesPerfil(ph.getHabilidad().getIdHabilidad(),
                                ph.getHabilidad().getNombre(), String.valueOf(ph.getNivel()),
                                ph.getAnosExperiencia())
                ).collect(Collectors.toList());

        ConsultaPerfil consultaPerfil = new ConsultaPerfil(consultarPerfil.getUsuario().getNombre(),
                consultarPerfil.getDescripcion(), consultarPerfil.getExperiencia(), consultarPerfil.getUbicacion(),
                consultarPerfil.getRedesSociales(), habilidadDTO);

        return  ResponseEntity.ok(consultaPerfil);
    }

    @GetMapping("/{idPerfil}")
    public ResponseEntity<ConsultaPerfil> obtenerPerfil(@PathVariable Long idPerfil){

        Perfil consultarPerfil = perfilService.consultarPerfil(idPerfil);

        List<HabilidadesPerfil> habilidadDTO = consultarPerfil.getPerfilHabilidad()
                .stream().map(
                        ph -> new HabilidadesPerfil(ph.getHabilidad().getIdHabilidad(),
                                ph.getHabilidad().getNombre(), String.valueOf(ph.getNivel()),
                                ph.getAnosExperiencia())
                ).collect(Collectors.toList());

        ConsultaPerfil consultaPerfil = new ConsultaPerfil(consultarPerfil.getUsuario().getNombre(),
                consultarPerfil.getDescripcion(), consultarPerfil.getExperiencia(), consultarPerfil.getUbicacion(),
                consultarPerfil.getRedesSociales(), habilidadDTO);

        return  ResponseEntity.ok(consultaPerfil);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<DatosPerfilActualizado> modificarPerfil (@RequestBody DatosPerfilActualizado datosPerfilActualizado,
                                                                   @AuthenticationPrincipal Usuario usuario){
        Perfil perfil = perfilService.modificarPerfil(datosPerfilActualizado, usuario);

        DatosPerfilActualizado dto = new DatosPerfilActualizado(perfil.getDescripcion(),
                perfil.getExperiencia(), perfil.getUbicacion(), perfil.getRedesSociales());

        return ResponseEntity.ok(dto);
    }
}
