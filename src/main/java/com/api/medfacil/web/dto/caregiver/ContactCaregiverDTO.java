package com.api.medfacil.web.dto.caregiver;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContactCaregiverDTO(

        @NotBlank
        String ddi,

        @NotBlank
        String ddd,

        @NotBlank
        String phoneNumber,

        @NotNull
        Integer caregiverId
) {
}
