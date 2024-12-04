package com.example.dolbomi;

import static com.example.dolbomi.global.constant.Timezone.*;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DolbomiApplication {

	@PostConstruct
	public void setUp(){
		TimeZone.setDefault(TimeZone.getTimeZone(LocalTimezone));
	}

	public static void main(String[] args) {
		SpringApplication.run(DolbomiApplication.class, args);
	}
}