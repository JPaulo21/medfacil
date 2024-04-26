package com.api.medfacil.web.dto.login;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank(message = "Campo cpf não foi preenchido")
        String cpf,

        @NotBlank(message = "Código não foi preenchido")
        String code
) {
}
