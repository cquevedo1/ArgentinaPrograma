package com.portfolioweb.portfolio.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioweb.portfolio.models.dtos.EstudiosRequest;
import com.portfolioweb.portfolio.models.entidades.EstudiosCursados;
import com.portfolioweb.portfolio.repository.EstudiosRepositorio;

@Service
public class EstudiosServicio {
    @Autowired
    EstudiosRepositorio estudiosRepositorio;

    @Autowired
    EstudiosCursados estudiosCursados;

    public List<EstudiosCursados> listado(){
        return estudiosRepositorio.findAll();
    }

    public EstudiosCursados buscarEstudiosId(String id)throws NoSuchElementException{
        return estudiosRepositorio.findById(id).orElse(null);
    }

    public boolean existeId(String id){
       return estudiosRepositorio.existsById(id);
    }

    @Transactional
    public void crearEstudios(EstudiosRequest estudiosRequest){
        estudiosCursados.setDescripcion(estudiosRequest.getDescripcion());
        estudiosCursados.setFechaInicio(estudiosRequest.getFechaInicio());
        estudiosCursados.setFechaFin(estudiosRequest.getFechaFin());
        estudiosCursados.setNombre(estudiosRequest.getNombre());
        estudiosRepositorio.save(estudiosCursados);
    }

    
    @Transactional
    public void modificarEstudios(String id, EstudiosRequest estudiosRequest ){

        if (estudiosRepositorio.existsById(id)) {
            estudiosCursados.setDescripcion(estudiosRequest.getDescripcion());
            estudiosCursados.setFechaInicio(estudiosRequest.getFechaInicio());
            estudiosCursados.setFechaFin(estudiosRequest.getFechaFin());
            estudiosCursados.setNombre(estudiosRequest.getNombre());
            estudiosRepositorio.save(estudiosCursados);
        }
    }

    @Transactional
    public void borrarEstudios(String id){
        if (estudiosRepositorio.existsById(id)) {
            estudiosRepositorio.deleteById(id);
        }
    }
}
