package com.br.api.barbershop.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Seu nome", example = "Alison")
    private String nome;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$", message = "Error, Mascara correta textoqualquer@hotmail.com")
    @Schema(description = "Seu email", example = "jose@hotmail.com")
    private String email;

    @NotBlank
    @Schema(description = "Sua senha", example = "1234")
    private String senha;

    @NotBlank
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", message = "Error, Mascara correta (xx) xxxxx-xxxx")
    @Schema(description = "Seu telefone", example = "(11) 91111-1111")
    private String telefone;

    @NotBlank
    @Schema(description = "Seu endereço", example = "Rua da liberdade")
    private String endereco;
}
