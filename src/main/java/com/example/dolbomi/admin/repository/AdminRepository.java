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

    List<SimpleUser> findUser(Integer adminIndex, Integer oldI);

    List<SimpleUser> findUserByStatus(Integer adminIndex, Integer status);

    Optional<Admin> findByRegisterNo(int registerNo);

    Integer findIndexByRegisterNo(Integer registerNo);
}