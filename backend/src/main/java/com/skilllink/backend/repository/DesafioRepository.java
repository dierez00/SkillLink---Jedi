package com.skilllink.backend.repository;

import com.skilllink.backend.entity.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesafioRepository extends JpaRepository<Desafio, Long> {

    @Query("SELECT d FROM Desafio d WHERE LOWER(d.descripcion) LIKE LOWER(CONCAT('%', :habilidad, '%'))")
    List<Desafio> findByHabilidadInDescripcion(@Param("habilidad") String habilidad);
}
