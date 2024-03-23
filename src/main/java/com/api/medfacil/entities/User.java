package com.api.medfacil.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "User")
@Table(name = "users",
        indexes = {@Index(name = "idx_phone_complete", columnList = "ddi, ddd, phone_number")})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 11)
    private String cpf;

    private String password;

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

    private String role;

    private boolean enable;

}
