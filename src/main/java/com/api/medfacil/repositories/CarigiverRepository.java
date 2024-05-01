package com.api.medfacil.repositories;

import com.api.medfacil.entities.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarigiverRepository extends JpaRepository<Caregiver, Integer> {

}
