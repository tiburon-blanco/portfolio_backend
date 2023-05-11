package com.martin.portfolio.controller;

import com.martin.portfolio.dto.LoginResponse;
import com.martin.portfolio.dto.LoginRequest;
import com.martin.portfolio.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Auth")
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse jwt = authenticationService.auth(loginRequest);
        return ResponseEntity.ok(jwt);
    }


}
