package com.martin.portfolio.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Persona {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String profesion;

    @Column
    private String fechaNacimiento;

    @Column
    private String web;

    @Column
    private String titulo;

    @Column
    private String telefono;

    @Column
    private String email;

    @Column
    private String ciudad;

    @Column
    private String disponibilidad;

    @Column
    private String description;
}
