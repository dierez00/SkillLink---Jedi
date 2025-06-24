package com.skilllink.backend.service;

import com.skilllink.backend.dto.habilidad.HabilidadDTO;
import com.skilllink.backend.dto.habilidad.NuevaHabilidadDTO;
import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.repository.HabilidadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDeHabilidad {

    @Autowired
    HabilidadRepositorio habilidadRepositorio;

    public Habilidad agregarHabilidad (NuevaHabilidadDTO nuevaHabilidad){

        Habilidad habilidad = new Habilidad();
        habilidad.setNombre(habilidad.getNombre());
        habilidad.setCategoria(habilidad.getCategoria());

        return habilidadRepositorio.save(habilidad);
    }


}
