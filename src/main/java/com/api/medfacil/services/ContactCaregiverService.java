package com.api.medfacil.services;

import com.api.medfacil.entities.ContactCaregiver;
import com.api.medfacil.repositories.ContactCaregiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactCaregiverService {

    private final ContactCaregiverRepository contactCaregiverRepository;

    public ContactCaregiver save(ContactCaregiver contactCaregiver) {
        return contactCaregiverRepository.save(contactCaregiver);
    }
}
