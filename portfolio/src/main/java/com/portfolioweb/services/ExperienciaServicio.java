package com.portfolioweb.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioweb.models.dtos.ExperienciaRequest;
import com.portfolioweb.models.entidades.ExperienciaLaboral;
import com.portfolioweb.repository.ExperienciaRepositorio;

@Service
public class ExperienciaServicio {
    @Autowired
    private ExperienciaRepositorio experienciaRepositorio;

    @Autowired
    private ExperienciaLaboral experienciaLaboral;

    public List<ExperienciaLaboral>listado(){
        return experienciaRepositorio.findAll();
    }

    public ExperienciaLaboral buscarExperienciaId(String id)throws NoSuchElementException{
        return experienciaRepositorio.findById(id).orElse(null);
    }

    public boolean existeId(String id){
       return experienciaRepositorio.existsById(id);
    }

    @Transactional
    public void agregarExperiencia(ExperienciaRequest experienciaRequest){
        experienciaLaboral.setDescripcion(experienciaRequest.getDescripcion());
        experienciaLaboral.setFechaInicio(experienciaRequest.getFechaInicio());
        experienciaLaboral.setFechaFin(experienciaRequest.getFechaFin());
        experienciaLaboral.setNombre(experienciaRequest.getNombre());
        experienciaRepositorio.save(experienciaLaboral);
    }

    
    @Transactional
    public void modificarExperiencia(String id, ExperienciaRequest experienciaRequest){

        if(experienciaRepositorio.existsById(id)) {
            experienciaLaboral.setDescripcion(experienciaRequest.getDescripcion());
            experienciaLaboral.setFechaInicio(experienciaRequest.getFechaInicio());
            experienciaLaboral.setFechaFin(experienciaRequest.getFechaFin());
            experienciaLaboral.setNombre(experienciaRequest.getNombre());
            experienciaRepositorio.save(experienciaLaboral);
        }
    }

    @Transactional
    public void borrarExperiencia(String id){
        if(experienciaRepositorio.existsById(id)) {
            experienciaRepositorio.deleteById(id);
        }
    }
}
