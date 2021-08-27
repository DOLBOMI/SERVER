package com.example.dolbomi.user.service;

import static com.example.dolbomi.global.constant.Timezone.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.example.dolbomi.global.util.crypto.CryptoData;
import com.example.dolbomi.global.util.crypto.SaltGenerator;
import com.example.dolbomi.global.util.crypto.Sha256Encryptor;
import com.example.dolbomi.user.controller.dto.JoinRequestDto;
import com.example.dolbomi.user.domain.User;
import com.example.dolbomi.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final Sha256Encryptor sha256Encryptor;

	public void join(JoinRequestDto dto){
		if (checkIsUserExist(dto.getRegisterNo())) {
			throw new IllegalArgumentException("이미 등록된 행정번호입니다.");
		}

		String salt = SaltGenerator.generateSalt();
		CryptoData cryptoData = CryptoData.WithSaltBuilder()
			.plainText(dto.getPassword())
			.salt(salt)
			.build();
		String encryptedPassword = sha256Encryptor.encrypt(cryptoData);
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of(LocalTimezone));

		User user = dto.makeEntity(salt, encryptedPassword, now, now, 0, 0);

		userRepository.insertUser(user);
	}

	private boolean checkIsUserExist(Integer registerNo) {
		return userRepository.findByRegisterNo(registerNo).isPresent();
	}
}
