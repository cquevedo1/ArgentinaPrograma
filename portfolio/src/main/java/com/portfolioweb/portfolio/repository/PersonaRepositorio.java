package com.portfolioweb.portfolio.repository;

import com.portfolioweb.portfolio.models.entidades.Persona;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, String> {
    @Query("SELECT p FROM Persona p WHERE p.id = :id")
    public Persona buscarPorID(@Param("id")String id);
}
