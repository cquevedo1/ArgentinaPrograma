package com.portfolioweb.portfolio.models.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class ExperienciaDTO {
    
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
}
