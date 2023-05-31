package com.br.api.barbershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {

    private Long idCliente;
    private String nome;
    private String email;
    private Integer ativo;
    private String telefone;
    private String endereco;
    private Integer pontos;
}
