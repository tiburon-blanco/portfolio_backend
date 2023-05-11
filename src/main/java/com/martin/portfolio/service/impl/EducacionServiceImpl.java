package com.martin.portfolio.service.impl;

import com.martin.portfolio.entity.Educacion;
import com.martin.portfolio.repository.EducacionRepository;
import com.martin.portfolio.service.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionServiceImpl implements EducacionService {

    @Autowired
    EducacionRepository educacionRepository;

    @Override
    public List<Educacion> list() {
        return educacionRepository.findAll();
    }

    @Override
    public Educacion create(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    @Override
    public Educacion update(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    @Override
    public void delete(long id) {
        educacionRepository.deleteById(id);
    }
}
