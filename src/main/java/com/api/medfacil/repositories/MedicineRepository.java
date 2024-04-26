package com.api.medfacil.repositories;

import com.api.medfacil.entities.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

    Page<Medicine> findByUserId(Integer id, Pageable page);
}
