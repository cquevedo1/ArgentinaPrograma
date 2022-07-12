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
import com.portfolioweb.models.dtos.ExperienciaRequest;
import com.portfolioweb.services.ExperienciaServicio;

@RestController
@RequestMapping("/experienciaLaboral")
@CrossOrigin(origins = "*")
public class ExperienciaController {
    
    @Autowired
    private ExperienciaServicio experienciaServicio;

    @PostMapping("/crear")
    public ResponseEntity<?> crearExperiencia(@RequestBody ExperienciaRequest experienciaRequest) {
  
        try {
            experienciaServicio.agregarExperiencia(experienciaRequest);
            return new ResponseEntity<>("Experiencia Laboral creada Exitosamente", HttpStatus.OK);
        } catch (Exception exception) {
            return ExceptionCustomHandler.throwError(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarExperienciaLaboral(@PathVariable("id") String id, @RequestBody ExperienciaRequest experienciaRequest) {
        try {
            experienciaServicio.modificarExperiencia(id, experienciaRequest);
            return new ResponseEntity<>("Datos modificados Exitosamente", HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return ExceptionCustomHandler.throwErrorNotFound(HttpStatus.NOT_FOUND, id);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarExperienciaLaboral(@PathVariable("id") String id){
        if (!experienciaServicio.existeId(id)){
            return new ResponseEntity<>("Id No Existe", HttpStatus.NOT_FOUND);
        }
        experienciaServicio.borrarExperiencia(id);
        return new ResponseEntity<>("Estudios Borrados", HttpStatus.OK);
    }
}
