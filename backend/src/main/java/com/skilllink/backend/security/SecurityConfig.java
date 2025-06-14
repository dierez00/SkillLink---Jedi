package com.skilllink.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        //deshabilita protección csrf
        return http.csrf(csfr -> csfr.disable())
                //Gestión de sesión stateless, no guarda la sesión en el servidor
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //Autentifica únicamente los request de la dirección /auth y subsecuentes
                .authorizeHttpRequests(authRequest -> authRequest.requestMatchers("/auth/**")
                        .permitAll().anyRequest().authenticated()).build();

    }

}
