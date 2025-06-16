package com.skilllink.backend.repositories;

import com.skilllink.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    UserDetails findByEmail(String email);


}
