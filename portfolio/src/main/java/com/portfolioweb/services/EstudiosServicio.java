package com.portfolioweb.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioweb.models.dtos.EstudiosRequest;
import com.portfolioweb.models.entidades.Estudios;
import com.portfolioweb.repository.EstudiosRepositorio;

@Service
public class EstudiosServicio {
    @Autowired
    private EstudiosRepositorio estudiosRepositorio;

    @Autowired
    private Estudios estudios;

    public List<Estudios> listado(){
        return estudiosRepositorio.findAll();
    }

    // public Estudios buscarEstudiosId(String id){
    //     return EstudiosRepositorio.buscarPorID(id);
    // }

    public Estudios buscarEstudiosId(String id)throws NoSuchElementException{
        return estudiosRepositorio.findById(id).orElse(null);
    }

    public boolean existeId(String id){
        return estudiosRepositorio.existsById(id);
    }

    @Transactional
    public void crearPersona(EstudiosRequest estudiosRequest) throws Exception{
        estudios.setDescripcion(estudiosRequest.getDescripcion());
        estudios.setFechaFin(estudiosRequest.getFechaFin());
        estudios.setFechaInicio(estudiosRequest.getFechaInicio());
        estudios.setNombre(estudiosRequest.getNombre());
        estudiosRepositorio.save(estudios);
    }

    
    @Transactional
    public void modificarEstudios(String id, EstudiosRequest estudiosRequest){
        if (estudiosRepositorio.existsById(id)) {
            estudios.setDescripcion(estudiosRequest.getDescripcion());
            estudios.setFechaFin(estudiosRequest.getFechaFin());
            estudios.setFechaInicio(estudiosRequest.getFechaInicio());
            estudios.setNombre(estudiosRequest.getNombre());
            estudiosRepositorio.save(estudios);
        }
        
    }

    @Transactional
    public void borrarEstudios(String id){
        if (estudiosRepositorio.existsById(id)) {
            estudiosRepositorio.deleteById(id);
        }
    }
    }

 