package com.api.medfacil.repositories;

import com.api.medfacil.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByCpf(String cpf);

    Optional<User> findByDdiAndDddAndPhoneNumber(String ddi, String ddd, String phoneNumber);

}
