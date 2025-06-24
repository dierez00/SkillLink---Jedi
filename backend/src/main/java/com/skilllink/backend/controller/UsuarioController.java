package com.skilllink.backend.controller;


import com.skilllink.backend.dto.usuario.UsuarioConsultaDTO;
import com.skilllink.backend.entity.usuario.Usuario;
import com.skilllink.backend.dto.usuario.UsuarioInfoSalida;
import com.skilllink.backend.repository.UsuarioRepositorio;
import com.skilllink.backend.service.ServicioDeUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    ServicioDeUsuario servicioDeUsuario;

    @GetMapping("/cuenta")
    public ResponseEntity<UsuarioConsultaDTO> obtenerUsuario(@AuthenticationPrincipal Usuario usuario) {

        Usuario consultarUsuario = servicioDeUsuario.consultarUsuario(usuario.getIdUsuario());
        UsuarioConsultaDTO usuarioConsultaDTO = new UsuarioConsultaDTO(consultarUsuario.getNombre(), consultarUsuario.getEmail(),
                consultarUsuario.getFechaRegistro());
        return ResponseEntity.ok(usuarioConsultaDTO);
    }

    @DeleteMapping("/eliminar-cuenta")
    public ResponseEntity<Void> eliminarUsuario(@AuthenticationPrincipal Usuario usuario) {
       servicioDeUsuario.eliminarUsuario(usuario.getIdUsuario());
        return ResponseEntity.noContent().build();
    }

}
