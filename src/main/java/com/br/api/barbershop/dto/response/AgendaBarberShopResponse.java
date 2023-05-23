package com.br.api.barbershop.dto.response;

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
public class AgendaBarberShopResponse {

    private Long idAgenda;
    private LocalDateTime dataAgenda;
    private TipoServico tipoServico;
    private Double preco;
}
