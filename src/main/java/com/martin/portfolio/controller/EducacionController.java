package com.martin.portfolio.controller;

import com.martin.portfolio.entity.Educacion;
import com.martin.portfolio.service.EducacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educacion")
@Tag(name = "Educacion", description = "Microservicio de educacion")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("")
    @Operation(summary = "Listado de educaciones")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    @Operation(summary = "Crear una educación", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Educacion> create(@RequestBody Educacion educacion){
        Educacion response = educacionService.create(educacion);
        return ResponseEntity.ok(response);
    }

    @PutMapping("")
    @Operation(summary = "Actualizar una educación", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Educacion> update(@RequestBody Educacion educacion){
        Educacion response = educacionService.update(educacion);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("")
    @Operation(summary = "Eliminar una educación", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Void> delete(@RequestParam(name = "id") long id){
        educacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
