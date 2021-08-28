package com.example.dolbomi.admin.service;

import com.example.dolbomi.admin.controller.dto.RegisterRequestDto;
import com.example.dolbomi.admin.controller.dto.ViewAllRequestDto;
import com.example.dolbomi.admin.controller.dto.ViewRequestDto;
import com.example.dolbomi.admin.controller.dto.ViewStatusRequestDto;
import com.example.dolbomi.admin.repository.AdminRepository;
import com.example.dolbomi.user.domain.User;
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

    public List<User> viewAll(ViewAllRequestDto dto){
        return adminRepository.findAllUser(dto.getAdminIndex());
    }

    public List<User> viewOld(ViewRequestDto dto){
        return adminRepository.findUser(dto.getOldIndex());
    }

    public List<User> viewStatus(ViewStatusRequestDto dto){
        return adminRepository.findUserByStatus(dto.getAdminIndex(), dto.getStatus());
    }
}