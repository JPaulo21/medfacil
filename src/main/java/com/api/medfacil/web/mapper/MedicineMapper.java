package com.api.medfacil.web.mapper;

import com.api.medfacil.entities.Medicine;
import com.api.medfacil.entities.User;
import com.api.medfacil.services.UserService;
import com.api.medfacil.web.dto.medicine.MedicineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserService.class})
public interface MedicineMapper {

    @Mapping(target = "user", source = "userId")
    Medicine toMedicine(MedicineDTO medicineDTO);

    default User mapUserIdtoUser(Integer userId, UserService userService){
        return userService.findById(userId);
    }
}
