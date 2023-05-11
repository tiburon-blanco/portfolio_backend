package com.martin.portfolio.service.impl;

import com.martin.portfolio.entity.Proyecto;
import com.martin.portfolio.repository.ProyectoRepository;
import com.martin.portfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> list() {
        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto create(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto update(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public void delete(long id) {
        proyectoRepository.deleteById(id);
    }
}
