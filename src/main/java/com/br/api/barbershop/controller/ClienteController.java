package com.br.api.barbershop.controller;

import com.br.api.barbershop.dto.request.ClienteRequest;
import com.br.api.barbershop.dto.request.LoginRequest;
import com.br.api.barbershop.dto.response.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Validated
@RequestMapping("/cliente")
public interface ClienteController {

    @Operation(summary = "Criar uma conta", description = "Salvar uma conta no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Criou com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/create")
    ResponseEntity<ClienteResponse> create(@Valid @RequestBody ClienteRequest clienteRequest);

    @Operation(summary = "Autentificar Usuário", description = "Autentificar usuário no aplicativo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/auth")
    ResponseEntity<String> authUser(@Valid @RequestBody LoginRequest loginRequest);
}
