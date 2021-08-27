package com.example.dolbomi.user.domain;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

	private Integer userIndex;
	private Integer registerNo;
	private String salt;
	private String password;
	private String name;
	private Integer age;
	private Integer sex;
	private double weight;
	private double height;
	private String phoneNo;
	private String phoneNo119;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private ZonedDateTime createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private ZonedDateTime updatedAt;
	private Integer status;
	private Integer isApproved;

	@Builder
	public User(Integer userIndex, Integer registerNo, String salt, String password, String name, Integer age, Integer sex, double weight, double height, String phoneNo, String phoneNo119, ZonedDateTime createdAt, ZonedDateTime updatedAt, Integer status, Integer isApproved){
		this.userIndex = userIndex;
		this.registerNo = registerNo;
		this.salt = salt;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.weight = weight;
		this.height = height;
		this.phoneNo = phoneNo;
		this.phoneNo119 = phoneNo119;
		this.createdAt = createdAt.withZoneSameInstant(ZoneId.systemDefault());
		this.updatedAt = updatedAt.withZoneSameInstant(ZoneId.systemDefault());
		this.status = status;
		this.isApproved = isApproved;
	}
}
