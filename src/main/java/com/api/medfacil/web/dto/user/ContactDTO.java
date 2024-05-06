package com.api.medfacil.web.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ContactDTO(

        @Email(message = "E-mail inválido!")
        String email,

        @NotBlank
        String ddi,

        @NotBlank
        String ddd,

        @NotBlank
        String phoneNumber
) {
}
