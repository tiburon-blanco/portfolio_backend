package com.martin.portfolio.service;

import com.martin.portfolio.entity.Educacion;

import java.util.List;

public interface EducacionService {

    /**
     * Devuelve la lista de educaciones
     * @return
     */
    List<Educacion> list();

    /**
     * Crea una educacion
     * @param educacion
     * @return
     */
    Educacion create(Educacion educacion);

    /**
     * Actualiza una educacion
     * @param educacion
     * @return
     */
    Educacion update(Educacion educacion);

    /**
     * Elimina una educacion
     * @param id
     */
    void delete(long id);
}
