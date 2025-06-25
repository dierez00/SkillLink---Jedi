package com.skilllink.backend.repository;

import com.skilllink.backend.dto.habilidad.HabilidadDTO;
import com.skilllink.backend.entity.Habilidad;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadRepositorio extends JpaRepository<Habilidad, Long> {

}
