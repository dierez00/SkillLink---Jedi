package com.skilllink.backend.controller;

import com.skilllink.backend.dto.UsuarioInfRegistro;
import com.skilllink.backend.dto.UsuarioInfoSalida;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.repositories.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping (value = "/register")
    public ResponseEntity<UsuarioInfoSalida> registro (@RequestBody UsuarioInfRegistro usuarioInfRegistro, UriComponentsBuilder uriComponentsBuilder){

        //Guarda la información del request en la base de datos usando
        Usuario usuario = usuarioRepositorio.save(new Usuario(usuarioInfRegistro));
        //Obtiene la información del request para regresar solo los datos relevantes
        UsuarioInfoSalida  usuarioInfoSalida = new UsuarioInfoSalida(usuarioInfRegistro.idUsuario(), usuarioInfRegistro.nombre(), usuarioInfRegistro.email(), usuarioInfRegistro.fechaDeRegistro());

        URI url = uriComponentsBuilder.path("/user/{idUsuario}").buildAndExpand(usuario.getIdUsuario()).toUri();
        return ResponseEntity.created(url).body(usuarioInfoSalida);


    }

}
