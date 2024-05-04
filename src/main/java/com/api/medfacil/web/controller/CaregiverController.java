package com.api.medfacil.web.controller;

import com.api.medfacil.entities.Caregiver;
import com.api.medfacil.entities.ContactCaregiver;
import com.api.medfacil.services.CaregiverService;
import com.api.medfacil.web.dto.caregiver.CaregiverDTO;
import com.api.medfacil.web.dto.caregiver.CaregiverQueryDTO;
import com.api.medfacil.web.mapper.CaregiverMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/user")
    public ResponseEntity<Page<CaregiverQueryDTO>> getCaregiversByUser(Pageable pageable){
        Page<Caregiver> caregiverPage = caregiverService.getCaregiverByUser(pageable);

        List<CaregiverQueryDTO> caregiverDTOList = caregiverPage.getContent()
                .stream()
                .map(caregiverMapper::toDTO)
                .toList();

        Page<CaregiverQueryDTO> caregiverQueryDTOPage = new PageImpl<CaregiverQueryDTO>(caregiverDTOList, caregiverPage.getPageable(),caregiverPage.getTotalElements());

        return ResponseEntity.ok(caregiverQueryDTOPage);
    }

}
