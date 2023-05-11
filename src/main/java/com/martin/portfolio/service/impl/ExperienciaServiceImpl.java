package com.martin.portfolio.service.impl;

import com.martin.portfolio.entity.Experiencia;
import com.martin.portfolio.repository.ExperienciaRepository;
import com.martin.portfolio.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaServiceImpl implements ExperienciaService {

    @Autowired
    ExperienciaRepository experienciaRepository;

    @Override
    public List<Experiencia> list() {
        return experienciaRepository.findAll();
    }

    @Override
    public Experiencia create(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    @Override
    public Experiencia update(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    @Override
    public void delete(long id) {
        experienciaRepository.deleteById(id);
    }
}
