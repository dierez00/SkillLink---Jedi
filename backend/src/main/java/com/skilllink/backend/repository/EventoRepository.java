package com.skilllink.backend.repository;

import com.skilllink.backend.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query("SELECT e FROM Evento e WHERE LOWER(e.descripcion) LIKE LOWER(CONCAT('%', :habilidad, '%'))")
    List<Evento> findByHabilidadInDescripcion(@Param("habilidad") String habilidad);

    List<Evento> findByDescripcionContainingIgnoreCase(String habilidad);

}
