package com.martin.portfolio.service.impl;

import com.martin.portfolio.entity.Persona;
import com.martin.portfolio.repository.PersonaRepository;
import com.martin.portfolio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public Persona get() {
        List<Persona> personaList = personaRepository.findAll();
        if(personaRepository.count() == 0){
            Persona persona = new Persona();
            return  persona;
        }
        return personaList.get(0);
    }

    @Override
    public Persona crearActualizar(Persona persona) {
        Persona update = get();
        update.setProfesion(persona.getProfesion());
        update.setFechaNacimiento(persona.getFechaNacimiento());
        update.setWeb(persona.getWeb());
        update.setTitulo(persona.getTitulo());
        update.setTelefono(persona.getTelefono());
        update.setEmail(persona.getEmail());
        update.setCiudad(persona.getCiudad());
        update.setDisponibilidad(persona.getDisponibilidad());
        update.setDescription(persona.getDescription());
        personaRepository.save(update);
        return update;
    }
}
