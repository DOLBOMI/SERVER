package com.example.dolbomi.sensor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FcmRequestDto {

    String targetToken;
    String title;
    //String messageBody;

    @Builder
    public FcmRequestDto(String targetToken, String title){
        this.title = title;
        this.targetToken = targetToken;
    }
}