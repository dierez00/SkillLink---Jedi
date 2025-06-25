package com.skilllink.backend.service;

import com.skilllink.backend.dto.perfil.DatosPerfil;
import com.skilllink.backend.dto.perfil.DatosPerfilActualizado;
import com.skilllink.backend.entity.Perfil;
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
public class ServicioDePerfil {

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

                PerfilHabilidad perfilHabilidad = new PerfilHabilidad();

                perfilHabilidad.setPerfil(perfil);
                perfilHabilidad.setHabilidad(habilidad);
                perfilHabilidad.setNivel(habilidadesSeleccionadas.nivel());
                perfilHabilidad.setAnosExperiencia(habilidadesSeleccionadas.anosDeExperiencia());

                perfil.getPerfilHabilidad().add(perfilHabilidad);
            }
        }
        return perfilRepositorio.save(perfil);
    }

    public Perfil modificarPerfil (DatosPerfilActualizado datosPerfilActualizado, Usuario usuario){

        Perfil perfil = perfilRepositorio.findById(usuario.getPerfil().getIdPerfil())
                .orElseThrow(() -> new EntityNotFoundException("usuario no encontrado"));

        if (datosPerfilActualizado.descripcion() != null){
            perfil.setDescripcion(datosPerfilActualizado.descripcion());
        }
        if (datosPerfilActualizado.experiencia() != null) {
            perfil.setExperiencia(datosPerfilActualizado.experiencia());
        }
        if (datosPerfilActualizado.redesSociales() != null) {
            perfil.setRedesSociales(datosPerfilActualizado.redesSociales());
        }
        if (datosPerfilActualizado.ubicacion() != null){
            perfil.setUbicacion(datosPerfilActualizado.ubicacion());
        }
        return perfilRepositorio.save(perfil);
    }

    public Perfil consultarPerfil (Long idPerfil){

        return perfilRepositorio.findById(idPerfil).orElseThrow(
                () -> new EntityNotFoundException("No se encontró el perfil")
        );
    }

}
