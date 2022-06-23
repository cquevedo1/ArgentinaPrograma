package com.portfolioweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.portfolioweb.models.entidades.Estudios;

@Repository
public interface EstudiosRepositorio extends JpaRepository<Estudios, String> {
    @Query("SELECT e FROM Estudios e WHERE e.id = :id")
   public Estudios buscarPorID(@Param("id")String id);//{
//         // TODO Auto-generated method stub
//         return null;
}

