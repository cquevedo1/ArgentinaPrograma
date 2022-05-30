package com.portfolioweb.portfolio.repository;

import com.portfolioweb.portfolio.models.entidades.ExperienciaLaboral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepositorio extends JpaRepository<ExperienciaLaboral, String> {
    
}
