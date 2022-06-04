package com.portfolioweb.portfolio.repository;

import com.portfolioweb.portfolio.models.entidades.ExperienciaLaboral;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepositorio extends JpaRepository<ExperienciaLaboral, String> {
    @Query("SELECT p FROM Persona p WHERE p.id = :id")
    public ExperienciaLaboral buscarPorID(@Param("id")String id);
}
