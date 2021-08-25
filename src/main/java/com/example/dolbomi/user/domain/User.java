package com.example.dolbomi.user.domain;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

	private Integer registerInfoIndex;
	private String salt;
	private String password;
	private String name;
	private Integer age;
	private Integer sex;
	private String phoneNo;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private ZonedDateTime createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private ZonedDateTime updatedAt;

	@Builder
	public User(Integer registerInfoIndex, String salt, String password, String name, Integer age, Integer sex, String phoneNo, ZonedDateTime createdAt, ZonedDateTime updatedAt){
		this.registerInfoIndex = registerInfoIndex;
		this.salt = salt;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phoneNo = phoneNo;
		this.createdAt = createdAt.withZoneSameInstant(ZoneId.systemDefault());;
		this.updatedAt = updatedAt.withZoneSameInstant(ZoneId.systemDefault());;
	}
}
