package com.skilllink.backend.service;

import com.skilllink.backend.dto.perfilHabilidad.ActualziarPerfilHabilidad;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesSeleccionadas;
import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.entity.Perfil;
import com.skilllink.backend.entity.PerfilHabilidad;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.repository.HabilidadRepositorio;
import com.skilllink.backend.repository.PerfilHabilidadRepositorio;
import com.skilllink.backend.repository.PerfilRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioDePerfilHabilidad {


    @Autowired
    PerfilRepositorio perfilRepositorio;
    @Autowired
    PerfilHabilidadRepositorio perfilHabilidadRepositorio;
    @Autowired
    HabilidadRepositorio habilidadRepositorio;


    public PerfilHabilidad actualizarUsuario (ActualziarPerfilHabilidad dto, Usuario usuario){

        PerfilHabilidad perfilHabilidad = perfilHabilidadRepositorio.findByPerfilUsuarioAndHabilidadIdHabilidad(usuario, dto.idHabilidad()).orElseThrow(
                () -> new EntityNotFoundException("No se encontro habilidad con id: " + dto.idHabilidad() + " relacionada al usuario")
        );

        if (dto.nivel() != null && !dto.nivel().isBlank()){
            perfilHabilidad.setNivel(dto.nivel());
        }
        if (dto.anosDeExperiencia() != null){
            perfilHabilidad.setAnosExperiencia(dto.anosDeExperiencia());
        }

        return perfilHabilidadRepositorio.save(perfilHabilidad);
    }

    public void eliminarHabilidad(Long idHabilidad, Usuario usuario){

        Perfil perfil = perfilRepositorio.findByUsuario(usuario);
        Habilidad habilidad = habilidadRepositorio.findById(idHabilidad).orElseThrow(
                () -> new  EntityNotFoundException ("Perfil no encontrado con usuario: " + usuario)
        );

        PerfilHabilidad habilidadAeliminar = perfilHabilidadRepositorio.findByPerfilAndHabilidad(perfil, habilidad)
                .orElseThrow(() -> new EntityNotFoundException("Esta habilidad no está asociada a tu perfil."));

        perfilHabilidadRepositorio.delete(habilidadAeliminar);

    }

    public List<HabilidadesSeleccionadas> agregarHabilidad(List<HabilidadesSeleccionadas> habilidadesSeleccionadas,
                                                           Usuario usuario) {
        Perfil perfil = perfilRepositorio.findByUsuario(usuario);

        List<Long> idHabilidadesExistentes = perfilHabilidadRepositorio.findIdHabilidadByPerfilId(perfil.getIdPerfil());

        List<PerfilHabilidad> nuevasAsociaciones = new ArrayList<>();

        for (HabilidadesSeleccionadas dto : habilidadesSeleccionadas) {
            if (idHabilidadesExistentes.contains(dto.idHabildad())) {
                throw new IllegalStateException("La habilidad con ID " + dto.idHabildad() + " ya está asociada a este perfil.");
            }

            Habilidad habilidad = habilidadRepositorio.findById(dto.idHabildad())
                    .orElseThrow(() -> new EntityNotFoundException("Habilidad no encontrada con ID: " + dto.idHabildad()));

            PerfilHabilidad nuevaAsociacion = new PerfilHabilidad();

            nuevaAsociacion.setPerfil(perfil);
            nuevaAsociacion.setHabilidad(habilidad);
            nuevaAsociacion.setNivel(dto.nivel());
            nuevaAsociacion.setAnosExperiencia(dto.anosDeExperiencia());
            nuevasAsociaciones.add(nuevaAsociacion);
        }
        List<PerfilHabilidad> asociacionesGuardadas = perfilHabilidadRepositorio.saveAll(nuevasAsociaciones);

        return asociacionesGuardadas.stream()
                .map(ph -> new HabilidadesSeleccionadas(
                        ph.getHabilidad().getIdHabilidad(),
                        ph.getNivel(),
                        ph.getAnosExperiencia()))
                .collect(Collectors.toList());

    }
}
