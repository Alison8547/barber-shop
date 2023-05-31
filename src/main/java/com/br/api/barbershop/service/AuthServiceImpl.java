package com.br.api.barbershop.service;

import com.br.api.barbershop.domain.ClienteEntity;
import com.br.api.barbershop.dto.request.LoginRequest;
import com.br.api.barbershop.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String auth(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        Object principal = authenticate.getPrincipal();

        ClienteEntity clienteEntity = (ClienteEntity) principal;

        return tokenService.getToken(clienteEntity);
    }
}
