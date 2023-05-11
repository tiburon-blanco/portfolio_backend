package com.martin.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Proyecto {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private Date fecha;

    @Column
    private String link;
}
