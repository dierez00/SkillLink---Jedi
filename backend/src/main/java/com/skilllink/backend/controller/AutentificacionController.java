package com.skilllink.backend.controller;

import com.skilllink.backend.dto.usuario.DatosAutentificacionUsuario;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.security.DatosJWTToken;
import com.skilllink.backend.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingresar")
public class AutentificacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DatosJWTToken> autenticarUsuario(@RequestBody @Valid DatosAutentificacionUsuario datosAutentificacionUsuario) {
        System.out.println("Autenticando a: " + datosAutentificacionUsuario.email());
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutentificacionUsuario.email(),
                datosAutentificacionUsuario.contrasena());

        try {
            Authentication usuarioAutenticado = authenticationManager.authenticate(authToken);
            String JWTToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());

            System.out.println("Se autentico exitosamente el correo " + datosAutentificacionUsuario.email());

            return ResponseEntity.ok(new DatosJWTToken(JWTToken));
        } catch (Exception e) {
            System.out.println("Error de autentificacion de usuario: " + datosAutentificacionUsuario.email() + " - " + e.getMessage());
            throw e;
        }

    }
}