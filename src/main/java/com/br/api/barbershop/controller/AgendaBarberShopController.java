package com.br.api.barbershop.controller;

import com.br.api.barbershop.dto.request.AgendaBarberShopRequest;
import com.br.api.barbershop.dto.response.AgendaBarberShopResponse;
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
@RequestMapping("/agenda")
public interface AgendaBarberShopController {
    @Operation(summary = "Criar uma agenda", description = "Salvar uma agenda no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Criou com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/create-agenda")
    ResponseEntity<AgendaBarberShopResponse> createAgenda(@Valid @RequestBody AgendaBarberShopRequest agendaBarberShopRequest);
}
