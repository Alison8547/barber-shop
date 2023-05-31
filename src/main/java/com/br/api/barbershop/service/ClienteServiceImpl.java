package com.br.api.barbershop.service;

import com.br.api.barbershop.domain.ClienteEntity;
import com.br.api.barbershop.dto.request.ClienteRequest;
import com.br.api.barbershop.dto.response.ClienteResponse;
import com.br.api.barbershop.mapper.ClienteMapper;
import com.br.api.barbershop.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final CargoService cargoService;
    private final PasswordEncoder passwordEncoder;
    private static final Integer ROLE_CLIENTE = 2;
    private static final Integer DEFAULT_PONTOS = 0;
    private static final Integer ENABLE_USER = 1;
    private static final Integer DISABLED_USER = 0;

    @Override
    public ClienteResponse saveCliente(ClienteRequest clienteRequest) {
        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(clienteRequest);

        clienteEntity.setCargo(cargoService.findCargo(ROLE_CLIENTE));
        clienteEntity.setPontos(DEFAULT_PONTOS);
        clienteEntity.setAtivo(ENABLE_USER);
        String passwordCrypt = passwordEncoder.encode(clienteRequest.getSenha());
        clienteEntity.setSenha(passwordCrypt);
        clienteRepository.save(clienteEntity);
        log.info("Cliente salvo com sucesso!");

        return clienteMapper.toClienteResponse(clienteEntity);
    }


    public Optional<ClienteEntity> findEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public Integer getIdLoggedUser() {
        return Integer.parseInt((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
