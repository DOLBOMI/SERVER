package com.example.dolbomi.admin.repository;

import com.example.dolbomi.user.domain.SimpleUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminRepository {

    void insertUserAdmin(Long oldIndex, Long adminIndex);

    List<SimpleUser> findAllUser();

    List<SimpleUser> findUser();

    List<SimpleUser> findUserByStatus();
}