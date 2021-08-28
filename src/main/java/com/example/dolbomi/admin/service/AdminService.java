package com.example.dolbomi.admin.service;

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
        Long oldIndex = dto.getOldIndex();
        Long adminIndex = dto.getAdminIndex();
        adminRepository.insertUserAdmin(oldIndex, adminIndex);
    }

    public List<SimpleUser> viewAll(){
        return adminRepository.findAllUser();
    }

    public List<SimpleUser> viewOld(){
        return adminRepository.findUser();
    }

    public List<SimpleUser> viewStatus(){
        return adminRepository.findUserByStatus();
    }
}