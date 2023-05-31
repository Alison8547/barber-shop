package com.br.api.barbershop.controller;

import com.br.api.barbershop.dto.request.ClienteRequest;
import com.br.api.barbershop.dto.request.LoginRequest;
import com.br.api.barbershop.dto.response.ClienteResponse;
import com.br.api.barbershop.service.AuthService;
import com.br.api.barbershop.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;
    private final AuthService authService;

    @Override
    public ResponseEntity<ClienteResponse> create(ClienteRequest clienteRequest) {
        return new ResponseEntity<>(clienteService.saveCliente(clienteRequest), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> authUser(LoginRequest loginRequest) {
        return new ResponseEntity<>(authService.auth(loginRequest), HttpStatus.OK);
    }
}
