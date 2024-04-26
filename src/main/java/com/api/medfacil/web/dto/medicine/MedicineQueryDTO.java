package com.api.medfacil.web.dto.medicine;

import jakarta.validation.constraints.NotBlank;

public record MedicineQueryDTO(
        @NotBlank
        Integer id,

        @NotBlank
        String name,

        @NotBlank
        String dosage,

        @NotBlank
        String pharmaceuticalForm
) {
}
