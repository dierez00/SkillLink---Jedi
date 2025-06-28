package com.skilllink.backend.repository;

import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.entity.Perfil;
import com.skilllink.backend.entity.PerfilHabilidad;
import com.skilllink.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerfilHabilidadRepositorio extends JpaRepository<PerfilHabilidad, Long> {


    @Query(
            value = "SELECT id_habilidad FROM Perfil_Habilidad WHERE id_perfil = :idPerfil",
            nativeQuery = true
    )
    List<Long> findIdHabilidadByPerfilId(@Param("idPerfil") Long perfilId);

    Optional<PerfilHabilidad> findByPerfilAndHabilidad(Perfil perfil, Habilidad habilidad);

    Optional<PerfilHabilidad> findByPerfilUsuarioAndHabilidadIdHabilidad(Usuario usuario, Long habilidadId);

}

