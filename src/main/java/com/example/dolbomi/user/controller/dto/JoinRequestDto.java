package com.example.dolbomi.user.controller.dto;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;

import com.example.dolbomi.user.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JoinRequestDto {

	@NotBlank(message = "노인 행정번호를 입력해주세요")
	private Integer registerNo;

	@NotBlank(message = "비밀번호를 입력해주세요")
	private String password;

	@NotBlank(message = "이름을 입력해주세요")
	private String name;

	@NotBlank(message = "나이를 입력해주세요")
	private Integer age;

	@NotBlank(message = "성별을 선택해주세요")
	private Integer sex;

	private Integer height;

	private Integer weight;

	@NotBlank(message = "전화번호를 입력해주세요")
	private String phoneNo;

	@NotBlank(message = "비상 전화번호를 입력해주세요")
	private String phoneNo119;

	@Builder
	public JoinRequestDto(Integer registerNo, String password, String name, Integer age, Integer sex, Integer weight, Integer height, String phoneNo, String phoneNo119){
		this.registerNo = registerNo;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.height = height;
		this.weight = weight;
		this.phoneNo = phoneNo;
		this.phoneNo119 = phoneNo119;
	}

	public User makeEntity(String salt, String encryptedPassword, ZonedDateTime createdAt, ZonedDateTime updatedAt, Integer status, Integer isApproved){
		return User.builder()
			.registerNo(registerNo)
			.salt(salt)
			.password(encryptedPassword)
			.name(name)
			.age(age)
			.sex(sex)
			.height(height)
			.weight(weight)
			.phoneNo(phoneNo)
			.phoneNo119(phoneNo119)
			.createdAt(createdAt)
			.updatedAt(updatedAt)
			.status(status)
			.isApproved((isApproved))
			.build();
	}
}