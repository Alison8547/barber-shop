package com.br.api.barbershop.dto.request;

import com.br.api.barbershop.enums.TipoServico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendaBarberShopRequest {

    // fazer validacao
    private LocalDateTime dataAgenda;

    private TipoServico tipoServico;
}
