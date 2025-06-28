package com.skilllink.backend.repository;

import com.skilllink.backend.entity.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MentoriaRepository extends JpaRepository<Mentoria, Long> {

    @Query("SELECT m FROM Mentoria m WHERE LOWER(m.descripcion) LIKE LOWER(CONCAT('%', :habilidad, '%'))")
    List<Mentoria> findByHabilidadInDescripcion(@Param("habilidad") String habilidad);

}
