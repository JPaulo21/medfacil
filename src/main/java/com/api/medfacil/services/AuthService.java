package com.api.medfacil.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    public String generateRandomCode(){
        Random random = new Random();
        return String.valueOf(random.nextInt(9000) + 1000);
    }
}
