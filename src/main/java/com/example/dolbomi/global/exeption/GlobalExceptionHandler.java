package com.example.dolbomi.global.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.dolbomi.global.common.FailResponse;
import com.example.dolbomi.global.common.StatusEnum;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public FailResponse handleUnauthorizedException(UnauthorizedException e){
        return FailResponse.builder()
            .status(StatusEnum.UNAUTHORIZED)
            .errorMessage(e.getMessage())
            .build();
    }
}