package com.martin.portfolio.service.impl;

import com.martin.portfolio.entity.Habilidad;
import com.martin.portfolio.repository.HabilidadRepository;
import com.martin.portfolio.service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadServiceImpl implements HabilidadService {

    @Autowired
    HabilidadRepository habilidadRepository;

    @Override
    public List<Habilidad> list() {
        return habilidadRepository.findAll();
    }

    @Override
    public Habilidad create(Habilidad habilidad) {
        return habilidadRepository.save(habilidad);
    }

    @Override
    public Habilidad update(Habilidad habilidad) {
        return habilidadRepository.save(habilidad);
    }

    @Override
    public void delete(long id) {
        habilidadRepository.deleteById(id);
    }
}
