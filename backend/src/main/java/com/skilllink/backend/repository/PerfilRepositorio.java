package com.skilllink.backend.repository;

import com.skilllink.backend.entity.perfil.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {

}
