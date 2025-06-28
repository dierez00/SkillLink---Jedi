package com.skilllink.backend.mapper;

import com.skilllink.backend.dto.perfilHabilidad.ActualziarHabilidad;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesSeleccionadas;
import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.entity.Perfil;
import com.skilllink.backend.entity.PerfilHabilidad;
import com.skilllink.backend.enums.NivelHabilidad;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PerfilHabilidadMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PerfilHabilidad toEntity(HabilidadesSeleccionadas dto, Habilidad habilidad, Perfil perfil){
        PerfilHabilidad perfilHabilidad = modelMapper.map(dto, PerfilHabilidad.class);
        perfilHabilidad.setNivel(NivelHabilidad.valueOf(dto.nivel()));
        perfilHabilidad.setHabilidad(habilidad);
        perfilHabilidad.setPerfil(perfil);
        perfilHabilidad.setAnosExperiencia(dto.anosDeExperiencia());
        return perfilHabilidad;
    }

    public void updateEntityFromDto(ActualziarHabilidad dto, PerfilHabilidad entidad){
        modelMapper.map(dto, entidad);
        if (dto.nivel() != null && !dto.nivel().isBlank()){
            entidad.setNivel(NivelHabilidad.valueOf(dto.nivel()));
        }
    }

    public HabilidadesSeleccionadas toDto (PerfilHabilidad entidad){
        return new HabilidadesSeleccionadas(
                entidad.getHabilidad().getIdHabilidad(),
                entidad.getNivel().name(),
                entidad.getAnosExperiencia()
        );
    }

}
