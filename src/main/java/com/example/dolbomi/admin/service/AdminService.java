package com.example.dolbomi.admin.service;

import com.example.dolbomi.admin.controller.dto.ChangeRequestDto;
import com.example.dolbomi.admin.controller.dto.DeleteRequestDto;
import com.example.dolbomi.admin.controller.dto.RegisterRequestDto;
import com.example.dolbomi.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public void register(RegisterRequestDto dto) {
        Long adminIndex = dto.getAdminIndex();
        Long registerNo = dto.getRegisterNo();

        Long oldIndex = new Long(checkIsRegisterNo(registerNo));

        if (oldIndex < 1) {
            throw new IllegalArgumentException("유효하지 않은 등록번호입니다.");
        } else if (checkIsUserAdmin(oldIndex, adminIndex)) {
            throw new IllegalArgumentException("이미 등록한 사용자입니다.");
        } else {
            adminRepository.insertUserAdmin(oldIndex, adminIndex);
        }

    }

    private boolean checkIsUserAdmin(Long oldIndex, Long adminIndex) {
        if(adminRepository.checkIsRegister(oldIndex, adminIndex) == null || adminRepository.checkIsRegister(oldIndex, adminIndex) < 1) {
            return false; // 등록되지 않은 등록번호
        } else return true;
    }

    private Integer checkIsRegisterNo(Long registerNo) {
        Integer oldIndex = adminRepository.checkIsValidRegisterNo(registerNo);
        if(oldIndex != null && oldIndex > 0) {
            return oldIndex;
        } else return 0;
    }

    public void delete(DeleteRequestDto dto) {
        Long oldIndex = dto.getOldIndex();
        Long adminIndex = dto.getAdminIndex();

        if(!checkIsUserAdmin(oldIndex, adminIndex)) {
            throw new IllegalArgumentException("관리하고 있는 노인이 아닙니다.");
        } else {
            adminRepository.DeleteUserAdmin(oldIndex, adminIndex);
        }
    }

    public void changeStatus(Integer idx, ChangeRequestDto dto) {
        Long oldIndex = new Long(idx);
        Long adminIndex = dto.getAdminIndex();
        Long status = dto.getStatus();
        
        if (status != 0 && status != 1 && status != 2) {
            throw new IllegalArgumentException("올바른 상태값을 입력해주세요.");
        }

        if(!checkIsUserAdmin(oldIndex, adminIndex)) {
            throw new IllegalArgumentException("관리하고 있는 노인이 아닙니다.");
        } else {
            adminRepository.ChangeUserStatus(status, oldIndex);
        }
    }
}
