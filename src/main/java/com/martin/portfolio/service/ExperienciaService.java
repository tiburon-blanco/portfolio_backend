package com.martin.portfolio.service;

import com.martin.portfolio.entity.Experiencia;

import java.util.List;

public interface ExperienciaService {

    /**
     * Devuelve la lista de experiencias
     * @return
     */
    List<Experiencia> list();

    /**
     * Crea una experiencia
     * @param experiencia
     * @return
     */
    Experiencia create(Experiencia experiencia);

    /**
     * Actualiza una experiencia
     * @param experiencia
     * @return
     */
    Experiencia update(Experiencia experiencia);

    /**
     * Elimina una experiencia
     * @param id
     */
    void delete(long id);
}
