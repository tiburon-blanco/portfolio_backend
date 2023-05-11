package com.martin.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Experiencia {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String logo;

    @Column
    private String empresa;

    @Column
    private String puesto;

    @Column
    private LocalDate desde;

    @Column
    private LocalDate hasta;

    @Column
    private String descripcion;
}
