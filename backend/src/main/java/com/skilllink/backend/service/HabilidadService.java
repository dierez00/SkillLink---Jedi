package com.skilllink.backend.service;

import com.skilllink.backend.dto.habilidad.NuevaHabilidadDTO;
import com.skilllink.backend.entity.Habilidad;
import com.skilllink.backend.repository.HabilidadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService {

    @Autowired
    HabilidadRepositorio habilidadRepositorio;

    public Page<Habilidad> listadoHabilidades (Pageable pageable){
        return habilidadRepositorio.findAll(pageable);
    }

    public Habilidad agregarHabilidad (NuevaHabilidadDTO nuevaHabilidad){

        Habilidad habilidad = new Habilidad();
        habilidad.setNombre(nuevaHabilidad.nombre());
        habilidad.setCategoria(nuevaHabilidad.categoria());

        return habilidadRepositorio.save(habilidad);
    }

    public void eliminarHabilidad (Long idHabilidad){
        habilidadRepositorio.deleteById(idHabilidad);
    }


}
