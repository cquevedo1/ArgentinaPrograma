package com.portfolioweb.portfolio.repository;

import com.portfolioweb.portfolio.models.entidades.EstudiosCursados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepositorio extends JpaRepository<EstudiosCursados, String> {
    
}
