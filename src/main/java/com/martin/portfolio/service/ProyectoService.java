package com.martin.portfolio.service;

import com.martin.portfolio.entity.Proyecto;

import java.util.List;

public interface ProyectoService {

    /**
     * Devuelve la lista de proyectos
     * @return
     */
    List<Proyecto> list();

    /**
     * Crea una proyecto
     * @param proyecto
     * @return
     */
    Proyecto create(Proyecto proyecto);

    /**
     * Actualiza una proyecto
     * @param proyecto
     * @return
     */
    Proyecto update(Proyecto proyecto);

    /**
     * Elimina una proyecto
     * @param id
     */
    void delete(long id);
}
