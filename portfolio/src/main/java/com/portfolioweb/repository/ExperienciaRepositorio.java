package com.portfolioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portfolioweb.models.entidades.ExperienciaLaboral;

@Repository
public interface ExperienciaRepositorio extends JpaRepository<ExperienciaLaboral, String> {
    @Query("SELECT e FROM ExperienciaLaboral e WHERE e.id = :id")
    public ExperienciaLaboral buscarPorID(@Param("id")String id);
}
