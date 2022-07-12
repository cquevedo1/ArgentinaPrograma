package com.portfolioweb.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolioweb.exceptions.ExceptionCustomHandler;
import com.portfolioweb.models.dtos.PersonaRequest;
import com.portfolioweb.services.PersonaServicio;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {
    @Autowired
    private PersonaServicio personaServicio;

    @PostMapping("/crear")
    public ResponseEntity<?> crearPersona(@RequestBody PersonaRequest personaRequest) {
  
        try {
            personaServicio.crearPersona(personaRequest);
            return new ResponseEntity<>("Persona creada Exitosamente", HttpStatus.OK);
        } catch (Exception exception) {
            return ExceptionCustomHandler.throwError(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarDatos(@PathVariable("id") String id, @RequestBody PersonaRequest personaRequest) {
        try {
            personaServicio.modificarDatos(id, personaRequest);
            return new ResponseEntity<>("Datos modificados Exitosamente", HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return ExceptionCustomHandler.throwErrorNotFound(HttpStatus.NOT_FOUND, id);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarPersona(@PathVariable("id") String id){
        if (!personaServicio.existeId(id))
            return new ResponseEntity<>("Id No Existe", HttpStatus.NOT_FOUND);
        personaServicio.borrarPersona(id);
        return new ResponseEntity<>("Persona Borrada", HttpStatus.OK);
    }

}

