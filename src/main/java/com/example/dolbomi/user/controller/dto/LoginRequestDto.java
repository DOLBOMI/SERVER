package com.example.dolbomi.user.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginRequestDto {

	@NotNull(message = "노인 행정번호를 입력해주세요")
	private int registerNo;

	@NotBlank(message = "비밀번호를 입력해주세요")
	private String password;

	@NotBlank(message = "이름을 입력해주세요")
	private String name;

	@Builder
	public LoginRequestDto(int registerNo, String password, String name, Integer age, Integer sex, Integer weight, Integer height, String phoneNo, String phoneNo119){
		this.registerNo = registerNo;
		this.password = password;
		this.name = name;
	}
}