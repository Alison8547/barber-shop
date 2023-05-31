package com.br.api.barbershop.service;

import com.br.api.barbershop.dto.request.AgendaBarberShopRequest;
import com.br.api.barbershop.dto.response.AgendaBarberShopResponse;
import com.br.api.barbershop.mapper.AgendaBarberShopMapper;
import com.br.api.barbershop.repository.AgendaBarberShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AgendaBarberShopServiceImpl implements AgendaBarberShopService {

    private final AgendaBarberShopRepository agendaBarberShopRepository;
    private final AgendaBarberShopMapper mapper;


    @Override
    public AgendaBarberShopResponse createAgenda(AgendaBarberShopRequest agendaBarberShopRequest) {
        return null;
    }
}
