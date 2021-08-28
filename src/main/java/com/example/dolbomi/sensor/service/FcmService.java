package com.example.dolbomi.sensor.service;
/*
import com.example.dolbomi.sensor.dto.FcmMessage;
import com.example.dolbomi.sensor.dto.FcmRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FcmService {

    private static final String API_URL = "https://fcm.googleapis.com/v1/projects/dolbomi-54fd9/messages:send";
    private final ObjectMapper objectMapper;

    public void sendMessageTo(FcmRequestDto dto) throws IOException {
        String message = makeMessage(dto.getTargetToken(), dto.getTitle(), dto.getBody());
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(message, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL)
                .post(requestBody)
                .addHeader("AUTHORIZATION", "Bearer " + getAccessToken())
                //.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; UTF-8")
                .build();

        Response response = client.newCall(request)
                .execute();
        //System.out.println(response.body().string());
    }

    private String makeMessage(String targetToken, String title, String body) throws JsonProcessingException {
        FcmMessage fcmMessage = FcmMessage.builder()
                .message(FcmMessage.Message.builder()
                        .token(targetToken)
                        .notification(FcmMessage.Notification.builder()
                                .title(title)
                                .body(body)
                                .image(null)
                                .build()
                        )
                        .build()
                )
                .validate_only(false)
                .build();

        //System.out.println(fcmMessage);
        return objectMapper.writeValueAsString(fcmMessage);
    }

    private static String getAccessToken() throws IOException {
        String firebaseConfigPath = "firebase/firebase_service_key.json";
        GoogleCredentials googleCredentials = GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream()).createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));
        googleCredentials.refreshIfExpired();

        return googleCredentials.getAccessToken().getTokenValue();
    }
}

*/
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class FcmService {
//
//}