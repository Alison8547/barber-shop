package com.br.api.barbershop.service;

import com.br.api.barbershop.domain.AgendaBarberShopEntity;
import com.br.api.barbershop.dto.request.AgendaBarberShopRequest;
import com.br.api.barbershop.dto.response.AgendaBarberShopResponse;
import com.br.api.barbershop.enums.TipoServico;
import com.br.api.barbershop.exception.BusinessException;
import com.br.api.barbershop.mapper.AgendaBarberShopMapper;
import com.br.api.barbershop.repository.AgendaBarberShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AgendaBarberShopServiceImpl implements AgendaBarberShopService {

    private final AgendaBarberShopRepository agendaBarberShopRepository;
    private final ClienteServiceImpl clienteService;
    private final AgendaBarberShopMapper mapper;
    private static final Integer TIME_AGENDA = 45;


    @Override
    public AgendaBarberShopResponse createAgenda(AgendaBarberShopRequest agendaBarberShopRequest) {
        Integer userLogged = clienteService.getIdLoggedUser();
        AgendaBarberShopEntity agendaBarberShopEntity = mapper.toAgendaBarberShopEntity(agendaBarberShopRequest);

        if (agendaBarberShopRequest.getDataAgenda().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Data de agendamento não pode ser no passado!");
        }

        LocalDateTime timeService = agendaBarberShopRequest.getDataAgenda().plusMinutes(TIME_AGENDA);

        List<LocalDateTime> list = agendaBarberShopRepository.findAll()
                .stream()
                .map(AgendaBarberShopEntity::getDataAgendaTimeService)
                .toList();

        for (LocalDateTime localDateTime : list) {
            if (agendaBarberShopRequest.getDataAgenda().isBefore(localDateTime)) {
                throw new BusinessException("Já tem cliente sendo atendido nesse horário!");
            }
        }

        agendaBarberShopEntity.setDataAgendaTimeService(timeService);

        if (agendaBarberShopRequest.getTipoServico().equalsIgnoreCase("Cabelo")) {
            agendaBarberShopEntity.setTipoServico(TipoServico.CABELO);
            agendaBarberShopEntity.setPreco(TipoServico.CABELO.getPreco());

        } else if (agendaBarberShopRequest.getTipoServico().equalsIgnoreCase("Barba")) {
            agendaBarberShopEntity.setTipoServico(TipoServico.BARBA);
            agendaBarberShopEntity.setPreco(TipoServico.BARBA.getPreco());
        } else {
            agendaBarberShopEntity.setTipoServico(TipoServico.PINTAR);
            agendaBarberShopEntity.setPreco(TipoServico.PINTAR.getPreco());
        }

        agendaBarberShopEntity.setCliente(clienteService.findCliente(userLogged));
        agendaBarberShopRepository.save(agendaBarberShopEntity);
        log.info("Agenda salva com sucesso!");

        return mapper.toAgendaBarberShopResponse(agendaBarberShopEntity);
    }
}
