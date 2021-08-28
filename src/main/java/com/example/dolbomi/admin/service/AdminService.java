package com.example.dolbomi.admin.service;

import com.example.dolbomi.admin.controller.dto.ChangeRequestDto;
import com.example.dolbomi.admin.controller.dto.DeleteRequestDto;
import com.example.dolbomi.admin.controller.dto.RegisterRequestDto;
import com.example.dolbomi.admin.controller.dto.*;
import com.example.dolbomi.admin.repository.AdminRepository;
import com.example.dolbomi.user.domain.SimpleUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public void register(RegisterRequestDto dto) {
        Integer adminIndex = dto.getAdminIndex();
        Integer registerNo = dto.getRegisterNo();

        Integer oldIndex = checkIsRegisterNo(registerNo);

        if (oldIndex < 1) {
            throw new IllegalArgumentException("유효하지 않은 등록번호입니다.");
        } else if (checkIsUserAdmin(oldIndex, adminIndex)) {
            throw new IllegalArgumentException("이미 등록한 사용자입니다.");
        }
        adminRepository.insertUserAdmin(oldIndex, adminIndex);
    }

    public List<SimpleUser> viewAll(Integer registerNo){
        Integer adminIndex = adminRepository.findIndexByRegisterNo(registerNo);
        return adminRepository.findAllUser(adminIndex);
    }

    public List<SimpleUser> viewOld(Integer registerNo, Integer oldI){
        Integer adminIndex = adminRepository.findIndexByRegisterNo(registerNo);
        return adminRepository.findUser(adminIndex, oldI);
    }
    private boolean checkIsUserAdmin(Integer oldIndex, Integer adminIndex) {
        if(adminRepository.checkIsRegister(oldIndex, adminIndex) == null || adminRepository.checkIsRegister(oldIndex, adminIndex) < 1) {
            return false;
        }
        return true;
    }

    private Integer checkIsRegisterNo(Integer registerNo) {
        Integer oldIndex = adminRepository.checkIsValidRegisterNo(registerNo);
        if(oldIndex != null && oldIndex > 0) {
            return oldIndex;
        }
        return 0;
    }

    public void delete(DeleteRequestDto dto) {
        Integer oldIndex = dto.getOldIndex();
        Integer adminIndex = dto.getAdminIndex();

        if(!checkIsUserAdmin(oldIndex, adminIndex)) {
            throw new IllegalArgumentException("관리하고 있는 노인이 아닙니다.");
        }
        adminRepository.deleteUserAdmin(oldIndex, adminIndex);
    }

    public void changeStatus(Integer idx, ChangeRequestDto dto) {
        Integer oldIndex = idx;
        Integer adminIndex = dto.getAdminIndex();
        Integer status = dto.getStatus();

        if (status != 0 && status != 1 && status != 2) {
            throw new IllegalArgumentException("올바른 상태값을 입력해주세요.");
        }
        if(!checkIsUserAdmin(oldIndex, adminIndex)) {
            throw new IllegalArgumentException("관리하고 있는 노인이 아닙니다.");
        }
        adminRepository.changeUserStatus(status, oldIndex);
    }

    public List<SimpleUser> viewStatus(Integer registerNo, Integer status){
        Integer adminIndex = adminRepository.findIndexByRegisterNo(registerNo);
        return adminRepository.findUserByStatus(adminIndex, status);
    }
}