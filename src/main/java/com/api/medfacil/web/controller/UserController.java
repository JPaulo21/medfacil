package com.api.medfacil.web.controller;

import com.api.medfacil.entities.User;
import com.api.medfacil.services.UserService;
import com.api.medfacil.web.dto.UserDTO;
import com.api.medfacil.web.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder ucb){
        User user = userService.save(userMapper.toUser(userDTO));
        URI location = ucb
                .path("/api/v1/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
