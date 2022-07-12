package com.portfolioweb.models.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class EstudiosRequest {
    
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
}
