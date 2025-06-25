package com.skilllink.backend.repository;

import com.skilllink.backend.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    @Query("SELECT p FROM Proyecto p WHERE LOWER(p.descripcion) LIKE LOWER(CONCAT('%', :habilidad, '%'))")
    List<Proyecto> findByHabilidadInDescripcion(@Param("habilidad") String habilidad);
}
