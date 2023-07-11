package com.br.api.barbershop.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendaBarberShopRequest {

    @NotNull
    @Schema(description = "Sua data de agendamento")
    private LocalDateTime dataAgenda;

    @NotNull
    @Schema(description = "Seu tipo de serviço", example = "Cabelo")
    private String tipoServico;
}
