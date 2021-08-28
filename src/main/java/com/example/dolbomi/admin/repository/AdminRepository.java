package com.example.dolbomi.admin.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminRepository {

    void insertUserAdmin(Integer oldIndex, Integer adminIndex);

    void deleteUserAdmin(Integer oldIndex, Integer adminIndex);

    void changeUserStatus(Integer status, Integer oldIndex);

    Integer checkIsRegister(Integer oldIndex, Integer adminIndex);

    Integer checkIsValidRegisterNo(Integer registerNo);
}