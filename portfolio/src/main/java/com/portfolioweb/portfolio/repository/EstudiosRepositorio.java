package com.portfolioweb.portfolio.repository;

import com.portfolioweb.portfolio.models.entidades.EstudiosCursados;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepositorio extends JpaRepository<EstudiosCursados, String> {
    @Query("SELECT e FROM EstudiosCursados e WHERE e.id = :id")
    public EstudiosCursados buscarPorID(@Param("id")String id);
}
