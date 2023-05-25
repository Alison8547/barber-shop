package com.br.api.barbershop.service;

import com.br.api.barbershop.domain.CargoEntity;
import com.br.api.barbershop.exception.BusinessException;
import com.br.api.barbershop.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;


    public CargoEntity findCargo(Integer idCargo) {
        return cargoRepository.findById(idCargo)
                .orElseThrow(() -> new BusinessException("Cargo não encontrado!"));
    }
}
