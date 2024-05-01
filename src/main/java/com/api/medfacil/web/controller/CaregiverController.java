package com.api.medfacil.web.controller;

import com.api.medfacil.entities.Caregiver;
import com.api.medfacil.services.CaregiverService;
import com.api.medfacil.web.dto.caregiver.CaregiverDTO;
import com.api.medfacil.web.mapper.CaregiverMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/caregivers")
@RequiredArgsConstructor
public class CaregiverController {

    private final CaregiverService caregiverService;
    private final CaregiverMapper caregiverMapper;

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody CaregiverDTO caregiverDTO, UriComponentsBuilder ucb){
        Caregiver caregiver = caregiverService.save(caregiverMapper.toEntity(caregiverDTO));
        URI location = ucb
                .path("/api/v1/caregivers/${id}")
                .buildAndExpand(caregiver.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
