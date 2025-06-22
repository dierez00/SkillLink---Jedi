package com.skilllink.backend.controller;


import com.skilllink.backend.entity.usuario.Usuario;
import com.skilllink.backend.dto.usuario.UsuarioInfoSalida;
import com.skilllink.backend.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    UsuarioRepositorio usuarioRepository;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioInfoSalida> obtenerUsuario(@PathVariable Long idUsuario) {


        Optional<Usuario> revisarUsuario = usuarioRepository.findById(idUsuario);

        if (revisarUsuario.isPresent()){
            Usuario usuario = revisarUsuario.get();
            UsuarioInfoSalida usuarioInfoSalida = new UsuarioInfoSalida(usuario.getIdUsuario(), usuario.getNombre(), usuario.getEmail(), usuario.getFechaRegistro());
            return ResponseEntity.ok(usuarioInfoSalida);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
