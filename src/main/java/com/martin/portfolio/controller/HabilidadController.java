package com.martin.portfolio.controller;

import com.martin.portfolio.entity.Habilidad;
import com.martin.portfolio.service.HabilidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
@Tag(name = "Habilidad", description = "Microservicio de habilidad")
public class HabilidadController {

    @Autowired
    HabilidadService habilidadService;

    @GetMapping("")
    @Operation(summary = "Listado de habilidades")
    public ResponseEntity<List<Habilidad>> list(){
        List<Habilidad> list = habilidadService.list();
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    @Operation(summary = "Crear una habilidad", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Habilidad> create(@RequestBody Habilidad habilidad){
        Habilidad response = habilidadService.create(habilidad);
        return ResponseEntity.ok(response);
    }

    @PutMapping("")
    @Operation(summary = "Actualizar una habilidad", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Habilidad> update(@RequestBody Habilidad habilidad){
        Habilidad response = habilidadService.update(habilidad);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("")
    @Operation(summary = "Eliminar una habilidad", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Void> delete(@RequestParam(name = "id") long id){
        habilidadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
