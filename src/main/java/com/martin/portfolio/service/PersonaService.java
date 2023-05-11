package com.martin.portfolio.service;

import com.martin.portfolio.entity.Persona;

public interface PersonaService {

    Persona get();

    Persona crearActualizar(Persona persona);
}
