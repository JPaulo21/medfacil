package com.api.medfacil.web.exceptions;

import org.springframework.http.HttpStatus;

public record ResponseError(

        HttpStatus status,
        int statusCode,
        String message
) {
}
    