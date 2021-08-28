package com.example.dolbomi.admin.repository;

import com.example.dolbomi.admin.domain.Admin;
import com.example.dolbomi.user.domain.SimpleUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface AdminRepository {

    void insertUserAdmin(Long oldIndex, Long adminIndex);

    List<SimpleUser> findAllUser(Integer adminIndex);

    List<SimpleUser> findUser();

    List<SimpleUser> findUserByStatus();

    Optional<Admin> findByRegisterNo(int registerNo);

    Integer findIndexByRegisterNo(Integer registerNo);
}