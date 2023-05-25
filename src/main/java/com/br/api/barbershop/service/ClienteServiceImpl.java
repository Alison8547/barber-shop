package com.br.api.barbershop.service;

import com.br.api.barbershop.domain.ClienteEntity;
import com.br.api.barbershop.dto.request.ClienteRequest;
import com.br.api.barbershop.dto.response.ClienteResponse;
import com.br.api.barbershop.mapper.ClienteMapper;
import com.br.api.barbershop.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final CargoService cargoService;
    private static final Integer ROLE_CLIENTE = 2;
    private static final Integer DEFAULT_PONTOS = 0;

    @Override
    public ClienteResponse saveCliente(ClienteRequest clienteRequest) {
        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(clienteRequest);

        clienteEntity.setCargo(cargoService.findCargo(ROLE_CLIENTE));
        clienteEntity.setPontos(DEFAULT_PONTOS);
        clienteRepository.save(clienteEntity);
        log.info("Cliente salvo com sucesso!");

        return clienteMapper.toClienteResponse(clienteEntity);
    }
}
