package com.example.dolbomi.user.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dolbomi.global.common.StatusEnum;
import com.example.dolbomi.global.common.SuccessResponse;
import com.example.dolbomi.user.controller.dto.JoinRequestDto;
import com.example.dolbomi.user.controller.dto.LoginRequestDto;
import com.example.dolbomi.user.service.LoginService;
import com.example.dolbomi.user.service.UserService;

import lombok.RequiredArgsConstructor;

@ResponseStatus
@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	private final LoginService loginService;

	@PostMapping("/users/sign-up")
	public SuccessResponse join(@Valid @RequestBody JoinRequestDto dto){
		userService.join(dto);
		SuccessResponse res = SuccessResponse.builder()
			.status(StatusEnum.CREATED)
			.message("회원가입 성공")
			.build();
		return res;
	}

	@PostMapping("/users/sign-in")
	public SuccessResponse login(@Valid @RequestBody LoginRequestDto dto){
		loginService.login(dto);
		SuccessResponse res = SuccessResponse.builder()
			.status(StatusEnum.OK)
			.message("로그인 성공")
			.build();
		return res;
	}

	@GetMapping("/users/logout")
	public void logoutUser(){
		loginService.logout();
	}
}
