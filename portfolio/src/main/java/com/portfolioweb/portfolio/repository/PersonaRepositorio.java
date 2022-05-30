package com.portfolioweb.portfolio.repository;

import com.portfolioweb.portfolio.models.entidades.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, String> {
    
}
