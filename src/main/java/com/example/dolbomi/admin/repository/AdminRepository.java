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

    void insertUserAdmin(Integer oldIndex, Integer adminIndex);

    void approveUser(Integer oldIndex);

    void disApproveUser(Integer oldIndex);

    List<SimpleUser> findAllUser(Integer adminIndex);

    List<SimpleUser> findUser(Integer adminIndex, Integer oldI);

    List<SimpleUser> findUserByStatus(Integer adminIndex, Integer status);

    Optional<Admin> findByRegisterNo(int registerNo);

    void deleteUserAdmin(Integer oldIndex, Integer adminIndex);

    void changeUserStatus(Integer status, Integer oldIndex);

    Integer checkIsRegister(Integer oldIndex, Integer adminIndex);

    Integer findIndexByRegisterNo(Integer registerNo);

    Integer checkIsValidRegisterNo(Integer registerNo);
}