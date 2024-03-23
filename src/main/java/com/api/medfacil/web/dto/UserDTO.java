package com.api.medfacil.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record UserDTO (
        @CPF
        String cpf,
        @NotBlank
        String name,
        @Past
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,
        @Length(min = 1, max = 1)
        String sex,
        @Email
        String email,
        String ddi,
        String ddd,
        String phoneNumber

){
}
