package com.skilllink.backend.service;

import com.skilllink.backend.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutentificacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Cargando detalles del correo: " + email);
        UserDetails userDetails = usuarioRepositorio.findByEmail(email);

        if (userDetails == null){
            throw new UsernameNotFoundException("No se encuentra un usuario con el correo: " + email);
        }

        System.out.println("Usuario encontrado con el correo: " + email);
        return userDetails;

    }
}
