package com.skilllink.backend.repository;

import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.entity.Perfil;
import com.skilllink.backend.entity.PerfilHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PerfilHabilidadRepositorio extends JpaRepository<PerfilHabilidad, Long> {


    @Query(
            value = "SELECT id_habilidad FROM perfil_habilidad WHERE id_perfil = :idPerfil",
            nativeQuery = true
    )
    List<Long> findIdHabilidadByPerfilId(@Param("idPerfil") Long perfilId);

    Optional<PerfilHabilidad> findByPerfilAndHabilidad(Perfil perfil, Habilidad habilidad);

}

