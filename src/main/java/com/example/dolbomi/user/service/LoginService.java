package com.example.dolbomi.user.service;

import com.example.dolbomi.user.controller.dto.LoginRequestDto;

public interface LoginService {

	void login(LoginRequestDto dto);
	void logout();
}