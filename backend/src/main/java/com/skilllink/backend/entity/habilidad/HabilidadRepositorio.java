package com.skilllink.backend.entity.habilidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepositorio extends JpaRepository<Habilidad, Long> {
}
