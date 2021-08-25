package com.example.dolbomi.user.controller.dto;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;

import com.example.dolbomi.user.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JoinRequestDto {

	@NotBlank(message = "노인 행정번호를 입력해주세요")
	private Integer registerInfoIndex;

	@NotBlank(message = "비밀번호를 입력해주세요")
	private String password;

	@NotBlank(message = "이름을 입력해주세요")
	private String name;

	@NotBlank(message = "나이를 입력해주세요")
	private Integer age;

	@NotBlank(message = "성별을 선택해주세요")
	private Integer sex;

	@NotBlank(message = "전화번호를 입력해주세요")
	private String phoneNo;

	@Builder
	public JoinRequestDto(Integer registerInfoIndex, String password, String name, Integer age, Integer sex, String phoneNo){
		this.registerInfoIndex = registerInfoIndex;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phoneNo = phoneNo;
	}

	public User makeEntity(String salt, String encryptedPassword, ZonedDateTime createdAt, ZonedDateTime updatedAt){
		return User.builder()
			.registerInfoIndex(registerInfoIndex)
			.salt(salt)
			.password(encryptedPassword)
			.name(name)
			.age(age)
			.sex(sex)
			.phoneNo(phoneNo)
			.createdAt(createdAt)
			.updatedAt(updatedAt)
			.build();
	}
}