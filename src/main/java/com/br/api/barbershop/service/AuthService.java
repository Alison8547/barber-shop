package com.br.api.barbershop.service;

import com.br.api.barbershop.dto.request.LoginRequest;

public interface AuthService {

    String auth(LoginRequest loginRequest);
}
