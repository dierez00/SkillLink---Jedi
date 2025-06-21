package com.skilllink.backend.controller;


import com.skilllink.backend.entity.perfil.DatosDeSalidaPerfil;
import com.skilllink.backend.entity.perfil.DatosPerfil;
import com.skilllink.backend.entity.perfil.Perfil;
import com.skilllink.backend.entity.perfil.ServicioModificacionDePerfil;
import com.skilllink.backend.entity.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/profile")
public class PerfilController {

    @Autowired
    ServicioModificacionDePerfil servicioModificacionDePerfil;

    @PostMapping
    //La etiqueta @Authentication Principal inyecta al usuario actualmente verifcado al controlador
    public ResponseEntity<DatosDeSalidaPerfil> crearPerfil (@RequestBody @Valid DatosPerfil datosPerfil, @AuthenticationPrincipal Usuario usuario, UriComponentsBuilder uriComponentsBuilder){


        Perfil perfil = servicioModificacionDePerfil.creacionDePerfil(usuario, datosPerfil);
        DatosDeSalidaPerfil datosDeSalidaPerfil = new DatosDeSalidaPerfil(perfil.getUsuario().getNombre(),
                perfil.getDescripcion(), perfil.getExperiencia(), perfil.getUbicacion(), perfil.getRedesSociales(), datosPerfil.habilidades());

        URI url = uriComponentsBuilder.path("/profile/{id}").buildAndExpand(perfil.getIdPerfil()).toUri();

        return ResponseEntity.created(url).body(datosDeSalidaPerfil);
    }

}
