package com.portfolioweb.portfolio.controllers;

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

import com.portfolioweb.portfolio.exceptions.ExceptionCustomHandler;
import com.portfolioweb.portfolio.models.dtos.EstudiosRequest;
import com.portfolioweb.portfolio.services.EstudiosServicio;

@RestController
@RequestMapping("/estudios")
@CrossOrigin(origins = "*")
public class EstudiosController {
    @Autowired
    EstudiosServicio estudiosServicio;

    @PostMapping("/crear")
    public ResponseEntity<?> crearEstudios(@RequestBody EstudiosRequest estudiosRequest) {
  
        try {
            estudiosServicio.crearEstudios(estudiosRequest);
            return new ResponseEntity<>("Estudios creados Exitosamente", HttpStatus.OK);
        } catch (Exception exception) {
            return ExceptionCustomHandler.throwError(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarDatos(@PathVariable("id") String id, @RequestBody EstudiosRequest estudiosRequest) {
        try {
            estudiosServicio.modificarEstudios(id, estudiosRequest);
            return new ResponseEntity<>("Datos modificados Exitosamente", HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return ExceptionCustomHandler.throwErrorNotFound(HttpStatus.NOT_FOUND, id);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarEstudios(@PathVariable("id") String id){
        if (!estudiosServicio.existeId(id))
            return new ResponseEntity<>("Id No Existe", HttpStatus.NOT_FOUND);
        estudiosServicio.borrarEstudios(id);
        return new ResponseEntity<>("Estudios Borrados", HttpStatus.OK);
    }
}
