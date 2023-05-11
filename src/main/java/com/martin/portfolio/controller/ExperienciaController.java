package com.martin.portfolio.controller;

import com.martin.portfolio.entity.Experiencia;
import com.martin.portfolio.service.ExperienciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
@Tag(name = "Experiencia", description = "Microservicio de expercias")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("")
    @Operation(summary = "Listado de experiencias")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    @Operation(summary = "Crear una experiencia", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Experiencia> create(@RequestBody Experiencia experiencia){
        Experiencia response = experienciaService.create(experiencia);
        return ResponseEntity.ok(response);
    }

    @PutMapping("")
    @Operation(summary = "Actualizar una experiencia", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Experiencia> update(@RequestBody Experiencia experiencia){
        Experiencia response = experienciaService.update(experiencia);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("")
    @Operation(summary = "Eliminar una experiencia", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Void> delete(@RequestParam(name = "id") long id){
        experienciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
