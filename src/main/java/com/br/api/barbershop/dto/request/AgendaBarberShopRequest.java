package com.br.api.barbershop.dto.request;

import com.br.api.barbershop.enums.TipoServico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendaBarberShopRequest {

    @NotNull
    @Past(message = "Data não pode ser no passado!")
    private LocalDateTime dataAgenda;

    @NotNull
    private TipoServico tipoServico;
}
