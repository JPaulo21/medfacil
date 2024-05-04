package com.api.medfacil.web.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UserDTO (
        @CPF(message = "CPF inválido!")
        String cpf,
        @NotBlank
        @Pattern(regexp = "[a-zA-ZÀ-ÿ\\s]+$", message = "Somente letras são permitidos")
        String name,
        @Past
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,
        @Length(min = 1, max = 1)
        String sex,

        ContactDTO contact

){
}
