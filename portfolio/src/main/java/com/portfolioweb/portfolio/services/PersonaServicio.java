package com.portfolioweb.portfolio.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioweb.portfolio.exceptions.DocumentAlreadyExistException;
import com.portfolioweb.portfolio.models.dtos.PersonaRequest;
import com.portfolioweb.portfolio.models.entidades.Persona;
import com.portfolioweb.portfolio.repository.PersonaRepositorio;

@Service
public class PersonaServicio {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @Autowired
    Persona persona;

    public List<Persona> listado(){
        return personaRepositorio.findAll();
    }

    public Persona buscarPersonaId(String id){
        return personaRepositorio.findById(id).orElse(null);
    }

    public boolean existeId(String id){
        return personaRepositorio.existsById(id);
    }

    @Transactional
    public void crearPersona(PersonaRequest personaRequest) throws DocumentAlreadyExistException{
        persona.setApellido(personaRequest.getApellido());
        persona.setLinkedin(personaRequest.getLinkedin());
        persona.setMail(personaRequest.getMail());
        persona.setNombre(personaRequest.getNombre());
        persona.setTelefono(personaRequest.getTelefono());
        persona.setDocumento(personaRequest.getDocumento());
        personaRepositorio.save(persona);
    }

    
    @Transactional
    public void modificarDatos(String id, PersonaRequest personaRequest){
        if (personaRepositorio.existsById(id)) {
            persona.setApellido(personaRequest.getApellido());
            persona.setLinkedin(personaRequest.getLinkedin());
            persona.setMail(personaRequest.getMail());
            persona.setNombre(personaRequest.getNombre());
            persona.setTelefono(personaRequest.getTelefono());
            persona.setDocumento(personaRequest.getDocumento());
            personaRepositorio.save(persona);
        }
        
    }

    @Transactional
    public void borrarPersona(String id){
        if (personaRepositorio.existsById(id)) {
            personaRepositorio.deleteById(id);
        }
    }
}
