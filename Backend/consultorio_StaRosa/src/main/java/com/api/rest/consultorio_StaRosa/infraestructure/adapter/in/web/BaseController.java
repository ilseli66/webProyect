package com.api.rest.consultorio_StaRosa.infraestructure.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.api.rest.consultorio_StaRosa.shared.application.Response;

public abstract class BaseController {
    protected <T> ResponseEntity<?> handleResult(Response<T> response) {
        if (response.succeeded()) {
            return switch (response.status()) {
                case CREATED -> new ResponseEntity<>(response, HttpStatus.CREATED);
                case SUCCESS -> new ResponseEntity<>(response, HttpStatus.OK);
                case NO_CONTENT -> new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
                default -> ResponseEntity.ok(response);
                 
            };
        }

        HttpStatus httpStatus = switch (response.status()) {
            case NOT_FOUND -> HttpStatus.NOT_FOUND;
            case VALIDATION_ERROR -> HttpStatus.BAD_REQUEST;
            case UNAUTHORIZED -> HttpStatus.UNAUTHORIZED;
            case FORBIDDEN -> HttpStatus.FORBIDDEN;
            case INTERNAL_ERROR -> HttpStatus.INTERNAL_SERVER_ERROR;
            default -> HttpStatus.BAD_REQUEST;
        };

        return new ResponseEntity<>(response, httpStatus);
    }
}
