package com.br.api.barbershop.service;

import com.br.api.barbershop.dto.request.AgendaBarberShopRequest;
import com.br.api.barbershop.dto.response.AgendaBarberShopResponse;

import javax.transaction.Transactional;

public interface AgendaBarberShopService {

    @Transactional
    AgendaBarberShopResponse createAgenda(AgendaBarberShopRequest agendaBarberShopRequest);
}
