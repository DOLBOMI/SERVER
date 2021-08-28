package com.example.dolbomi.user.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import com.example.dolbomi.user.domain.User;

@Mapper
@Repository
public interface UserRepository {

	void insertUser(User user);

	Optional<User> findByUserRegisterNo(int registerNo);
}