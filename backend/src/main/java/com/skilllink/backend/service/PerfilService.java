package com.skilllink.backend.service;

import com.skilllink.backend.dto.perfil.DatosPerfil;
import com.skilllink.backend.dto.perfil.DatosPerfilActualizado;
import com.skilllink.backend.entity.Perfil;
import com.skilllink.backend.enums.NivelHabilidad;
import com.skilllink.backend.repository.PerfilRepositorio;
import com.skilllink.backend.dto.perfilHabilidad.HabilidadesSeleccionadas;
import com.skilllink.backend.entity.PerfilHabilidad;
import com.skilllink.backend.entity.Usuario;
import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.repository.HabilidadRepositorio;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerfilService {

    @Autowired
    private PerfilRepositorio perfilRepositorio;
    @Autowired
    private HabilidadRepositorio habilidadRepositorio;

    @Transactional
    public Perfil creacionDePerfil (Usuario usuario, DatosPerfil datosPerfil){

        Perfil perfil = new Perfil();

        perfil.setDescripcion(datosPerfil.descripcion());
        perfil.setExperiencia(datosPerfil.experiencia());
        perfil.setUbicacion(datosPerfil.ubicacion());
        perfil.setRedesSociales(datosPerfil.redesSociales());

        //Se establece la relación por medio del usuario actual a traves de la etiqueta @AuthenticationPrincipal
        perfil.setUsuario(usuario);


        //Evalua si se ingresaron datos en la lista de habilidades
        if (datosPerfil.habilidades() != null && !datosPerfil.habilidades().isEmpty()){

            //Itera sobre la lista de habilidades para extraer sus atributos
            for (HabilidadesSeleccionadas habilidadesSeleccionadas : datosPerfil.habilidades()){

                //Busca el ID de la habilidad para corroborar que exista dentro de la base de datos
                //LINEA DE CODIGO A EVALUAR A FUTURO SI ES REDUDANTE EN CASO DE QUE LAS HABILIDADES ESTEN LIMITADAS A UNA LISTA DE OPCIONES YA DADAS POR LA DB
                Habilidad habilidad = habilidadRepositorio.findById(habilidadesSeleccionadas.idHabildad())
                        .orElseThrow(() -> new RuntimeException("No existe  la habilidad con la id:"));

                PerfilHabilidad ph = new PerfilHabilidad();

                ph.setPerfil(perfil);
                ph.setHabilidad(habilidad);
                ph.setNivel(NivelHabilidad.valueOf(habilidadesSeleccionadas.nivel()));
                ph.setAnosExperiencia(habilidadesSeleccionadas.anosDeExperiencia());

                perfil.getPerfilHabilidad().add(ph);
            }
        }
        return perfilRepositorio.save(perfil);
    }

    public Perfil modificarPerfil (DatosPerfilActualizado dto, Usuario usuario){

        Perfil perfil = perfilRepositorio.findById(usuario.getPerfil().getIdPerfil())
                .orElseThrow(() -> new EntityNotFoundException("usuario no encontrado"));

        if (dto.descripcion() != null){
            perfil.setDescripcion(dto.descripcion());
        }
        if (dto.experiencia() != null) {
            perfil.setExperiencia(dto.experiencia());
        }
        if (dto.redesSociales() != null) {
            perfil.setRedesSociales(dto.redesSociales());
        }
        if (dto.ubicacion() != null){
            perfil.setUbicacion(dto.ubicacion());
        }
        return perfilRepositorio.save(perfil);
    }

    public Perfil consultarPerfil (Long idPerfil){

        return perfilRepositorio.findById(idPerfil).orElseThrow(
                () -> new EntityNotFoundException("No se encontró el perfil")
        );
    }

}
