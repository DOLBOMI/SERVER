package com.example.dolbomi.sensor.controller;

import com.example.dolbomi.sensor.dto.FcmRequestDto;
import com.example.dolbomi.sensor.service.FcmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FcmController {

    private final FcmService fcmService;

    @PostMapping("/push-notification")
    public void pushNotification(@Valid @RequestBody FcmRequestDto fcmRequestDto) throws IOException {
        fcmService.sendMessageTo(fcmRequestDto);
    }
}