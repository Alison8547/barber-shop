package com.br.api.barbershop.controller;

import com.br.api.barbershop.dto.request.AgendaBarberShopRequest;
import com.br.api.barbershop.dto.response.AgendaBarberShopResponse;
import com.br.api.barbershop.service.AgendaBarberShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AgendaBarberShopControllerImpl implements AgendaBarberShopController{

    private final AgendaBarberShopService agendaBarberShopService;

    @Override
    public ResponseEntity<AgendaBarberShopResponse> createAgenda(AgendaBarberShopRequest agendaBarberShopRequest) {
        return new ResponseEntity<>(agendaBarberShopService.createAgenda(agendaBarberShopRequest),HttpStatus.CREATED);
    }
}
