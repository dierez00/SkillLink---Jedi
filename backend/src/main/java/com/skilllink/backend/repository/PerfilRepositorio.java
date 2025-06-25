package com.skilllink.backend.repository;

import com.skilllink.backend.entity.Perfil;
import com.skilllink.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {

    Perfil findByUsuario (Usuario usuario);

}
