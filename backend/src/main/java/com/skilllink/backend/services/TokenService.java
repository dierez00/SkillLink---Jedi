package com.skilllink.backend.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.skilllink.backend.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken (Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("SkillLink")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getIdUsuario())
                    .withExpiresAt(generarFechaDeVencimiento())
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new RuntimeException();
        }
    }

    public Instant generarFechaDeVencimiento(){
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-5:00"));
    }

    public String getSubject (String tokenJWT){
        try{
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.require(algorithm)
                    .withSubject("SkillLink")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTCreationException e){
            throw new RuntimeException();
        }

    }

}
