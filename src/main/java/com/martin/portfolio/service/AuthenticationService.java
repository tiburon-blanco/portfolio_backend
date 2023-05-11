package com.martin.portfolio.service;

import com.martin.portfolio.dto.LoginResponse;
import com.martin.portfolio.dto.LoginRequest;

public interface AuthenticationService {

    LoginResponse auth(LoginRequest loginRequest);
}
