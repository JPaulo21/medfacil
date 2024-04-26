package com.api.medfacil.web.controller;

import com.api.medfacil.entities.Medicine;
import com.api.medfacil.services.MedicineService;
import com.api.medfacil.web.dto.medicine.MedicineDTO;
import com.api.medfacil.web.dto.medicine.MedicineQueryDTO;
import com.api.medfacil.web.mapper.MedicineMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/user/{id}")
    public ResponseEntity<Page<MedicineQueryDTO>> getMedicinesByUser(@PageableDefault(size = 10) Pageable page, @PathVariable Integer id){
        Page<Medicine> medicinePage = medicineService.getMedicinesByUser(id, page);

        List<MedicineQueryDTO> listMedicineDTO = medicinePage
                .getContent()
                .stream()
                .map(medicineMapper::toMedicineQueryDTO)
                .toList();

        Page<MedicineQueryDTO> medicineDTOPage = new PageImpl<>(listMedicineDTO, medicinePage.getPageable(), medicinePage.getTotalElements());

        return ResponseEntity
                .ok(medicineDTOPage);
    }
}














