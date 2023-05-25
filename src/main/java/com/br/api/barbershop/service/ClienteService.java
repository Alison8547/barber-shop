package com.br.api.barbershop.service;

import com.br.api.barbershop.dto.request.ClienteRequest;
import com.br.api.barbershop.dto.response.ClienteResponse;

import javax.transaction.Transactional;

public interface ClienteService {

    @Transactional
    ClienteResponse saveCliente(ClienteRequest clienteRequest);
}
