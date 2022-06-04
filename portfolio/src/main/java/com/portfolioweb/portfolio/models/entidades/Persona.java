package com.portfolioweb.portfolio.models.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Persona {

    @Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
    private String nombre;
    private String apellido;
    private String documento;
    private String mail;
    private String telefono;
    private String linkedin;
}
