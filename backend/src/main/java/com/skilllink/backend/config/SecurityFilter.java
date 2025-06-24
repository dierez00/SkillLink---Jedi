package com.skilllink.backend.config;

import com.skilllink.backend.repository.UsuarioRepositorio;
import com.skilllink.backend.security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("Filtrando solicitud: " + request.getRequestURI());
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null){
            String token = authHeader.replace("Bearer", "").trim();
            String subject = tokenService.getSubject(token);

            if (subject != null){
                UserDetails user = usuarioRepositorio.findByEmail(subject);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,
                        null,
                        user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                System.out.println("Usuario autenticado: " + subject);
            }
        }

        filterChain.doFilter(request, response);

    }
}
