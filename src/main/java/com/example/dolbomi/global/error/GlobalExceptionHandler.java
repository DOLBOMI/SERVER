package com.example.dolbomi.global.error;

import com.example.dolbomi.global.common.FailResponse;
import com.example.dolbomi.global.common.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public FailResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("MethodArgumentNotValidException", e);
        return FailResponse.builder()
                .status(StatusEnum.BAD_REQUEST)
                .errorMessage(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public FailResponse handleIllegalArgumentException(IllegalArgumentException e){
        log.error("IllegalArgumentException", e);
        return FailResponse.builder()
                .status(StatusEnum.BAD_REQUEST)
                .errorMessage(e.getMessage())
                .build();
    }
}
