package com.example.dolbomi.admin.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface AdminRepository {

    void insertUserAdmin(Long oldIndex, Long adminIndex);

}
