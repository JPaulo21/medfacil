package com.api.medfacil.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity(name = "User")
@Table(name = "users",
        indexes = {@Index(name = "idx_phone_complete", columnList = "ddi, ddd, phone_number")})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 11)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }

    public String fullNumber(){
        return this.ddi+this.ddd.replace("0","")+this.phoneNumber;
    }
}
