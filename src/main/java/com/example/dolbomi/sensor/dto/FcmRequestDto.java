package com.example.dolbomi.sensor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FcmRequestDto {

    String targetToken;
    String title;
    String body;

    @Builder
    public FcmRequestDto(String targetToken, String title, String body){
        this.body = body;
        this.title = title;
        this.targetToken = targetToken;
    }
}