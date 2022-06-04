package com.portfolioweb.portfolio.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.portfolioweb.portfolio.models.dtos.ExperienciaRequest;
import com.portfolioweb.portfolio.models.entidades.ExperienciaLaboral;
import com.portfolioweb.portfolio.repository.ExperienciaRepositorio;


public class ExperienciaServicio {
    @Autowired
    ExperienciaRepositorio experienciaRepositorio;

    @Autowired
    ExperienciaLaboral experienciaLaboral;

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
    public void modificarEstudios(String id, ExperienciaRequest experienciaRequest){

        if(experienciaRepositorio.existsById(id)) {
            experienciaLaboral.setDescripcion(experienciaRequest.getDescripcion());
            experienciaLaboral.setFechaInicio(experienciaRequest.getFechaInicio());
            experienciaLaboral.setFechaFin(experienciaRequest.getFechaFin());
            experienciaLaboral.setNombre(experienciaRequest.getNombre());
            experienciaRepositorio.save(experienciaLaboral);
        }
    }

    @Transactional
    public void borrarEstudios(String id){
        if(experienciaRepositorio.existsById(id)) {
            experienciaRepositorio.deleteById(id);
        }
    }
}
