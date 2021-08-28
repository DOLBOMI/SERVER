package com.example.dolbomi.admin.repository;

import com.example.dolbomi.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminRepository {

    void insertUserAdmin(Long oldIndex, Long adminIndex);

    List<User> findAllUser(Long adminIndex);

    List<User> findUser(Long oldIndex);

    List<User> findUserByStatus(Long adminIndex, Long status);
}