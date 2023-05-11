package com.martin.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Habilidad {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String nombre;

    @Column
    private int grado;
}
