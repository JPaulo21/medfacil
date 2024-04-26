package com.api.medfacil.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicineDTO(
        @NotBlank
        String name,

        @NotBlank
        String dosage,

        @NotBlank
        String pharmaceuticalForm,

        @NotNull
        Integer userId
) {
}
