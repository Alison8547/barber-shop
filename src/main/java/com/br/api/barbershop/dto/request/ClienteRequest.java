package com.br.api.barbershop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$", message = "Error, Mascara correta textoqualquer@hotmail.com")
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "Error, Mascara correta (xx) xxxxx-xxxx")
    private String telefone;

    @NotBlank
    private String endereco;
}
