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
public class LoginRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$", message = "Error, Mascara correta textoqualquer@hotmail.com")
    @Schema(description = "Seu email", example = "alison@hotmail.com")
    private String email;

    @NotBlank
    @Schema(description = "Sua senha", example = "1234")
    private String senha;
}
