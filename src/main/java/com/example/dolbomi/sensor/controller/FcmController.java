package com.example.dolbomi.sensor.controller;

//import com.example.dolbomi.sensor.dto.FcmRequestDto;
//import com.example.dolbomi.sensor.service.FcmService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.io.IOException;
//
//@RestController
//@RequiredArgsConstructor
//public class FcmController {
//
//    private final FcmService fcmService;
//
//    @PostMapping("/push-notification")
//    public void pushNotification(@Valid @RequestBody FcmRequestDto fcmRequestDto) throws IOException {
//        fcmService.sendMessageTo(fcmRequestDto);
//    }
//}

import com.example.dolbomi.sensor.dto.FcmRequestDto;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FcmController {

    //@RequestMapping("push-notification")
    @PostMapping("/push-notification")
    public String sendToToken(@RequestBody final FcmRequestDto requestDto) throws FirebaseMessagingException {

        // This registration token comes from the client FCM SDKs.
        //String registrationToken = "cOWZLlgbRCa5-Jc410XiHw:APA91bG5MHD26TBdPfWEN1u1UuMmL1mGBR4I4ZkeXCGc9-Xschk0cJX69l7DD_58jbTxbZ532er5Yd3__16hy4aDw6wosCzLHiPAF8Iek6rSV2-I50rGkaA6-FJ0X4TV5vxtLbCd1xcM";
        //String registrationToken = "dUIyHeODTnudDptikkpCEP:APA91bE-np6adPG8oTMZl-dbhvRRTtGOeaAeXdvMlJMwu3CR0v4sgVrp3skyUTQDPT1PMbDY6sf3lLqpHwdmtQy_mcv36qeFUbClTvGXSkk7dUD5pE053O0zc3WzpGJVPvUUOEZQdTPZ";
        //String registrationToken = "fHuyHTWaTZyqYjjtFweWlT:APA91bHoy3yqaAdtByjuCcpmZpOfwAjyX_C9gZZnQDFJklT25tACAemkif9sW87S3cM5i3bB8tcNOK45AiZ-rRxqMtC_qVmKW68PIUrzaWNxJ6kCkXm_wLR2fuTjHCiN_womEPCYYPtq";

        // See documentation on defining a message payload.
        Message message = Message.builder()
                .putData("title", requestDto.getTitle())
                //.putData("messageBody", requestDto.getMessageBody())
                .setToken(requestDto.getTargetToken())
                .build();

        // Send a message to the device corresponding to the provided
        // registration token.
        String response = FirebaseMessaging.getInstance().send(message);
        // Response is a message ID string.
        System.out.println("Successfully sent message: " + response);

        return response;
    }
}