package com.br.api.barbershop.mapper;

import com.br.api.barbershop.domain.AgendaBarberShopEntity;
import com.br.api.barbershop.dto.request.AgendaBarberShopRequest;
import com.br.api.barbershop.dto.response.AgendaBarberShopResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgendaBarberShopMapper {

    private final ModelMapper mapper;


    public AgendaBarberShopEntity toAgendaBarberShopEntity(AgendaBarberShopRequest agendaBarberShopRequest) {
        return mapper.map(agendaBarberShopRequest, AgendaBarberShopEntity.class);
    }

    public AgendaBarberShopResponse toAgendaBarberShopResponse(AgendaBarberShopEntity agendaBarberShopEntity) {
        return mapper.map(agendaBarberShopEntity, AgendaBarberShopResponse.class);
    }
}
