package com.api.medfacil.web.controller;

import com.api.medfacil.entities.Medicine;
import com.api.medfacil.services.MedicineService;
import com.api.medfacil.web.dto.medicine.MedicineDTO;
import com.api.medfacil.web.mapper.MedicineMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/medicines")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;
    private final MedicineMapper medicineMapper;

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody MedicineDTO medicineDTO, UriComponentsBuilder ucb){
        Medicine medicine = medicineService.save(medicineMapper.toMedicine(medicineDTO));
        URI location = ucb
                .path("/api/v1/medicines/{id}")
                .buildAndExpand(medicine.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}














