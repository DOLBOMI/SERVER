package com.example.dolbomi.user.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dolbomi.global.common.StatusEnum;
import com.example.dolbomi.global.common.SuccessResponse;
import com.example.dolbomi.user.controller.dto.JoinRequestDto;
import com.example.dolbomi.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	@ResponseStatus
	@PostMapping("/users/sign-up")
	public SuccessResponse join(@Valid @RequestBody JoinRequestDto dto){
		userService.join(dto);
		SuccessResponse res = SuccessResponse.builder()
			.status(StatusEnum.CREATED)
			.message("회원가입 성공")
			.build();
		return res;
	}
}
