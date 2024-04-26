package com.api.medfacil.services;

import com.api.medfacil.entities.Medicine;
import com.api.medfacil.repositories.MedicineRepository;
import com.api.medfacil.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository medicineRepository;
    private final UserRepository userRepository;

    @Transactional
    public Medicine save(Medicine medicine){
        return medicineRepository.save(medicine);
    }

    public Page<Medicine> getMedicinesByUser(Integer id, Pageable page) {
        userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado!")
        );

        Page<Medicine> medicinePage = medicineRepository.findByUserId(id, page);

        return medicinePage;
    }
}
