package com.skilllink.backend.controller;


import com.skilllink.backend.dto.usuario.RolDTO;
import com.skilllink.backend.dto.usuario.UsuarioConsultaDTO;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.enums.RolUsuario;
import com.skilllink.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/cuenta")
    public ResponseEntity<UsuarioConsultaDTO> obtenerUsuario(@AuthenticationPrincipal Usuario usuario) {

        Usuario consultarUsuario = usuarioService.consultarUsuario(usuario.getIdUsuario());
        UsuarioConsultaDTO usuarioConsultaDTO = new UsuarioConsultaDTO(consultarUsuario.getNombre(), consultarUsuario.getEmail(),
                consultarUsuario.getFechaRegistro());
        return ResponseEntity.ok(usuarioConsultaDTO);
    }

    @DeleteMapping("/eliminar-cuenta")
    public ResponseEntity<Void> eliminarUsuario(@AuthenticationPrincipal Usuario usuario) {
       usuarioService.eliminarUsuario(usuario.getIdUsuario());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RolDTO>> obtenerRoles (){
        List<RolDTO> rolUsuarioList = Arrays.stream(RolUsuario.values()).map(
                rolUsuario -> new RolDTO(rolUsuario.name(), rolUsuario.getRolVisible())).toList();
        return ResponseEntity.ok(rolUsuarioList);
    }

}
