package com.example.letscookit.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@ControllerAdvice
class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //On bindibg (validation failure) return customized, more informative response
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> msgs = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(x -> msgs.add(x.getDefaultMessage()));
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "failed to validate", msgs.toString());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);


    }
}
