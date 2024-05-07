package com.api.medfacil.repositories;

import com.api.medfacil.entities.MedicationTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationTimeRepository extends JpaRepository<MedicationTime, Integer> {
}