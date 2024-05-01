package com.api.medfacil.web.dto.caregiver;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CaregiverDTO(
        @NotBlank(message = "Nome do cuidador não foi preenchido")
        @Pattern(regexp = "[a-zA-ZÀ-ÿ\\s]+$", message = "Somente letras e espaços são permitidos")
        String name,

        @NotNull(message = "Id do usuário não foi preenchido")
        Integer userId
) {
}
