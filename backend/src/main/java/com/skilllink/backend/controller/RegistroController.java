package com.skilllink.backend.controller;

import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.dto.usuario.UsuarioInfRegistro;
import com.skilllink.backend.dto.usuario.UsuarioInfoSalida;
import com.skilllink.backend.repository.UsuarioRepositorio;
import com.skilllink.backend.service.ServicioDeRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/registro")
public class RegistroController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ServicioDeRegistro servicioDeRegistro;

    @PostMapping
    public ResponseEntity<UsuarioInfoSalida> registro (@RequestBody UsuarioInfRegistro usuarioInfRegistro, UriComponentsBuilder uriComponentsBuilder){


        //Guarda la información del request en la base de datos usando
        Usuario usuario = servicioDeRegistro.registro(usuarioInfRegistro);

        //Obtiene la información del request para regresar solo los datos relevantes
        UsuarioInfoSalida  usuarioInfoSalida = new UsuarioInfoSalida(usuario.getIdUsuario(), usuarioInfRegistro.nombre(), usuarioInfRegistro.email(), usuario.getFechaRegistro());

        URI url = uriComponentsBuilder.path("/user/{idUsuario}").buildAndExpand(usuario.getIdUsuario()).toUri();
        return ResponseEntity.created(url).body(usuarioInfoSalida);


    }

}
