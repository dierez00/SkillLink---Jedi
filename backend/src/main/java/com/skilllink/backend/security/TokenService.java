package com.skilllink.backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.skilllink.backend.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.auth0.jwt.exceptions.JWTCreationException;

@Service
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
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject (String tokenJWT){

        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.require(algorithm)
                    .withIssuer("SkillLink")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }

    }

    private Instant generarFechaDeVencimiento(){
        return Instant.now().plus(3, ChronoUnit.HOURS);
    }


}

