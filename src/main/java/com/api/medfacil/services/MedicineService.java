package com.api.medfacil.services;

import com.api.medfacil.entities.Medicine;
import com.api.medfacil.repositories.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository medicineRepository;

    @Transactional
    public Medicine save(Medicine medicine){
        return medicineRepository.save(medicine);
    }
}
