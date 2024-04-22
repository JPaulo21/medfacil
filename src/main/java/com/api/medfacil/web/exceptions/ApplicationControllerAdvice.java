package com.api.medfacil.web.exceptions;

import com.api.medfacil.exceptions.CpfRegisteredException;
import com.api.medfacil.exceptions.FullNumberRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ResponseError> usernameNotFoundException(UsernameNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ResponseError(e.getMessage()));
    }

    @ExceptionHandler(CpfRegisteredException.class)
    public ResponseEntity<ResponseError> cpfRegisteredException(CpfRegisteredException e){
        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ResponseError(e.getMessage()));
    }

    @ExceptionHandler(FullNumberRegisteredException.class)
    public ResponseEntity<ResponseError> fullNumberRegisteredException(FullNumberRegisteredException e){
        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ResponseError(e.getMessage()));
    }


}
