package com.martin.portfolio.controller;

import com.martin.portfolio.entity.Proyecto;
import com.martin.portfolio.service.ProyectoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@Tag(name = "Proyecto", description = "Microservicio de proyecto")
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("")
    @Operation(summary = "Listado de proyectos")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    @Operation(summary = "Crear un proyecto", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Proyecto> create(@RequestBody Proyecto proyecto){
        Proyecto response = proyectoService.create(proyecto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("")
    @Operation(summary = "Actualizar un proyecto", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Proyecto> update(@RequestBody Proyecto proyecto){
        Proyecto response = proyectoService.update(proyecto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("")
    @Operation(summary = "Eliminar un proyecto", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Void> delete(@RequestParam(name = "id") long id){
        proyectoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
