package com.portfolioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portfolioweb.models.entidades.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, String> {
    @Query("SELECT p FROM Persona p WHERE p.id = :id")
    public Persona buscarPorID(@Param("id")String id);
}
