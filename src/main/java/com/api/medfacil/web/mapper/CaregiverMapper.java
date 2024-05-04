package com.api.medfacil.web.mapper;

import com.api.medfacil.entities.Caregiver;
import com.api.medfacil.entities.User;
import com.api.medfacil.services.UserService;
import com.api.medfacil.web.dto.caregiver.CaregiverDTO;
import com.api.medfacil.web.dto.caregiver.CaregiverQueryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserService.class})
public interface CaregiverMapper {

    @Mapping(target = "user",source = "userId")
    Caregiver toEntity(CaregiverDTO caregiverDTO);

    CaregiverQueryDTO toDTO(Caregiver caregiver);

    default User mapUserIdtoUser(Integer userId, UserService userService){
        return userService.findById(userId);
    }

}
