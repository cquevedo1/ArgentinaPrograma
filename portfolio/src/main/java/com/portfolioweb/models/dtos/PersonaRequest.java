package com.portfolioweb.models.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PersonaRequest {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    private String mail;
    private String telefono;
    private String linkedin;
    private String documento;
}
