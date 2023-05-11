package com.martin.portfolio.service;

import com.martin.portfolio.entity.Habilidad;

import java.util.List;

public interface HabilidadService {

    /**
     * Devuelve la lista de habilidades
     * @return
     */
    List<Habilidad> list();

    /**
     * Crea una habilidad
     * @param habilidad
     * @return
     */
    Habilidad create(Habilidad habilidad);

    /**
     * Actualiza una habilidad
     * @param habilidad
     * @return
     */
    Habilidad update(Habilidad habilidad);

    /**
     * Elimina una habilidad
     * @param id
     */
    void delete(long id);
}
