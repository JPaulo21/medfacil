package com.api.medfacil.services;

import com.api.medfacil.entities.Caregiver;
import com.api.medfacil.entities.User;
import com.api.medfacil.repositories.CarigiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaregiverService {

    private final CarigiverRepository carigiverRepository;
    private final AuthService authService;

    public Caregiver save(Caregiver caregiver) {

        return carigiverRepository.save(caregiver);
    }

    public Page<Caregiver> getCaregiverByUser(Pageable pageable) {
        User user = authService.getUserAuthentication();
        Page<Caregiver> caregiverPage = carigiverRepository.findByUserId(user.getId(), pageable);
        return caregiverPage;
    }
}
