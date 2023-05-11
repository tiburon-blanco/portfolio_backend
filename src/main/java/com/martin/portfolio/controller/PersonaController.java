package com.martin.portfolio.controller;

import com.martin.portfolio.dto.LoginResponse;
import com.martin.portfolio.entity.Persona;
import com.martin.portfolio.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@Tag(name = "persona", description = "Persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("")
    public ResponseEntity<Persona> get() {
        Persona persona = personaService.get();
        return ResponseEntity.ok(persona);
    }

    @PostMapping("")
    @Operation(summary = "Crear o actualiza datos de la persona", security = {@SecurityRequirement(name = "bearer-jwt")})
    public ResponseEntity<Persona> createUpdate(@RequestBody Persona persona) {
        Persona response = personaService.crearActualizar(persona);
        return ResponseEntity.ok(response);
    }

}
