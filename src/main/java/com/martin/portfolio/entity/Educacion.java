package com.martin.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Educacion {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String instituto;

    @Column
    private String logo;

    @Column
    private String nombre;

    @Column
    private String periodo;

}
