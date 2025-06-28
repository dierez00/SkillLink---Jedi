package com.skilllink.backend.controller;

import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.repository.UsuarioRepository;
import com.skilllink.backend.config.JwtPasswordTokenService;
import com.skilllink.backend.messaging.PasswordResetPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/recuperar")
public class RecuperacionController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtPasswordTokenService tokenService;

    @Autowired
    private PasswordResetPublisher passwordResetPublisher;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> enviarToken(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        return usuarioRepository.findByEmail(email)
                .map(usuario -> {
                    String token = tokenService.generateToken(email);
                    passwordResetPublisher.sendResetLink(email, token);
                    return ResponseEntity.ok("Correo de recuperación enviado");
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Correo no encontrado"));
    }

    @PostMapping("/reset")
    public ResponseEntity<?> restablecer(@RequestBody Map<String, String> body) {
        String token = body.get("token");
        String nuevaContrasena = body.get("nueva");

        try {
            String email = tokenService.validateToken(token);
            Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow();
            usuario.setContrasena(passwordEncoder.encode(nuevaContrasena));
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("Contraseña actualizada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido o expirado");
        }
    }
}
