package com.api.medfacil.services;

import com.api.medfacil.entities.Caregiver;
import com.api.medfacil.repositories.CarigiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaregiverService {

    private final CarigiverRepository carigiverRepository;

    public Caregiver save(Caregiver caregiver) {

        return carigiverRepository.save(caregiver);
    }
}
