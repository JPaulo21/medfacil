package com.api.medfacil.web.dto.user;

import jakarta.validation.constraints.Email;

public record ContactDTO(

        @Email(message = "E-mail inválido!")
        String email,

        String ddi,

        String ddd,

        String phoneNumber
) {
}
