package com.br.api.barbershop.mapper;

import com.br.api.barbershop.domain.ClienteEntity;
import com.br.api.barbershop.dto.request.ClienteRequest;
import com.br.api.barbershop.dto.response.ClienteResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

    private final ModelMapper mapper;


    public ClienteEntity toClienteEntity(ClienteRequest clienteRequest) {
        return mapper.map(clienteRequest, ClienteEntity.class);
    }

    public ClienteResponse toClienteResponse(ClienteEntity clienteEntity) {
        return mapper.map(clienteEntity, ClienteResponse.class);
    }
}
