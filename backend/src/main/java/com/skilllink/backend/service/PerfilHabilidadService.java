package com.skilllink.backend.service;

import com.skilllink.backend.dto.perfilHabilidad.ActualziarHabilidad;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesPerfil;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesSeleccionadas;
import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.entity.Perfil;
import com.skilllink.backend.entity.PerfilHabilidad;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.enums.NivelHabilidad;
import com.skilllink.backend.mapper.PerfilHabilidadMapper;
import com.skilllink.backend.repository.HabilidadRepositorio;
import com.skilllink.backend.repository.PerfilHabilidadRepositorio;
import com.skilllink.backend.repository.PerfilRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class PerfilHabilidadService {


    @Autowired
    PerfilRepositorio perfilRepositorio;
    @Autowired
    PerfilHabilidadRepositorio perfilHabilidadRepositorio;
    @Autowired
    HabilidadRepositorio habilidadRepositorio;
    @Autowired
    PerfilHabilidadMapper perfilHabilidadMapper;


    public PerfilHabilidad actualizarUsuario (ActualziarHabilidad dto, Usuario usuario){
        PerfilHabilidad perfilHabilidad = perfilHabilidadRepositorio
                .findByPerfilUsuarioAndHabilidadIdHabilidad(usuario, dto.idHabilidad()).orElseThrow(
                () -> new EntityNotFoundException("No se encontro habilidad con id: " + dto.idHabilidad() + " relacionada al usuario")
        );

        perfilHabilidadMapper.updateEntityFromDto(dto,perfilHabilidad);

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

    public List<HabilidadesSeleccionadas> agregarHabilidad(List<HabilidadesSeleccionadas> habilidades,
                                                           Usuario usuario) {
        Perfil perfil = perfilRepositorio.findByUsuario(usuario);
        List<Long> idHabilidadesExistentes = perfilHabilidadRepositorio.findIdHabilidadByPerfilId(perfil.getIdPerfil());
        List<PerfilHabilidad> nuevosPh = habilidades.stream().map(dto -> {

            if (idHabilidadesExistentes.contains(dto.idHabildad())){
                throw new IllegalStateException("Habilidad con id " + dto.idHabildad() + " ya existe en el perfil");
            }
            Habilidad habilidad = habilidadRepositorio.findById(dto.idHabildad())
                    .orElseThrow(() -> new EntityNotFoundException("Habilidad no encontrada con id" + dto.idHabildad()));

            PerfilHabilidad nuevoPh = perfilHabilidadMapper.toEntity(dto, habilidad, perfil);

            return nuevoPh;
        }).toList();

        List<PerfilHabilidad> habilidadList = perfilHabilidadRepositorio.saveAll(nuevosPh);

        return habilidadList.stream().map(perfilHabilidadMapper::toDto).toList();

    }
}
