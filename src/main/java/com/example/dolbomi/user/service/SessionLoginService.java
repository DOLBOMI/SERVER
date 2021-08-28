package com.example.dolbomi.user.service;

import static com.example.dolbomi.global.util.session.SessionUtil.*;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.dolbomi.admin.domain.Admin;
import com.example.dolbomi.admin.repository.AdminRepository;
import com.example.dolbomi.global.util.crypto.CryptoData;
import com.example.dolbomi.global.util.crypto.Encryptor;
import com.example.dolbomi.global.util.session.SessionUtil;
import com.example.dolbomi.user.controller.dto.LoginRequestDto;
import com.example.dolbomi.user.domain.User;
import com.example.dolbomi.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SessionLoginService implements LoginService{

	private final UserRepository userRepository;
	private final AdminRepository adminRepository;
	private final HttpSession httpSession;
	private final Encryptor encryptor;

	@Override
	public void login(LoginRequestDto dto){
		Optional<User> user;
		Optional<Admin> admin;

		if (!(userRepository.findByRegisterNo(dto.getRegisterNo()).isPresent() || adminRepository.findByRegisterNo(dto.getRegisterNo()).isPresent())){
			throw new IllegalArgumentException("존재하지 않는 행정번호입니다.");
		}

		if(dto.getRegisterNo()<900000){
			user = userRepository.findByRegisterNo(dto.getRegisterNo());
			CryptoData cryptoData = CryptoData.WithSaltBuilder()
				.plainText(dto.getPassword())
				.salt(user.get().getSalt())
				.build();
			String encryptedPassword = encryptor.encrypt(cryptoData);
			if(!encryptedPassword.equals(user.get().getPassword())){
				throw new IllegalArgumentException("패스워드가 틀렸습니다.");
			}
			httpSession.setAttribute(SessionUtil.LOGIN_USER_REGISTER_NO, user.get().getRegisterNo());
		}
		else {
			admin = adminRepository.findByRegisterNo(dto.getRegisterNo());
			String password = admin.get().getPassword();
			if(!password.equals(dto.getPassword())){
				throw new IllegalArgumentException("패스워드가 틀렸습니다.");
			}
			httpSession.setAttribute(SessionUtil.LOGIN_ADMIN_REGISTER_NO, admin.get().getRegisterNo());
		}
	}

	@Override
	public void logout(){
		httpSession.removeAttribute(LOGIN_USER_REGISTER_NO);
		httpSession.removeAttribute(LOGIN_ADMIN_REGISTER_NO);
	}

	public Integer getAdminRegisterNo(){
		return (Integer)httpSession.getAttribute(LOGIN_ADMIN_REGISTER_NO);
	}
}