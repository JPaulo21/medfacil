package com.api.medfacil.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "User")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String cpf;

    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(length = 1)
    private String sex;

    private String email;

    @Column(length = 4)
    private String ddi;

    @Column(length = 3)
    private String ddd;

    @Column(name = "phone_number", length = 9)
    private String phoneNumber;

}
