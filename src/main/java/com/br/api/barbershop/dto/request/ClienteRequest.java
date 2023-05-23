package com.br.api.barbershop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    // fazer validacao
    private String nome;

    private String email;

    private String senha;

    private String telefone;

    private String endereco;
}
