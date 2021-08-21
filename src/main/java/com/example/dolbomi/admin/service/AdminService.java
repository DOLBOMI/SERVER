package com.example.dolbomi.admin.service;

import com.example.dolbomi.admin.controller.dto.RegisterRequestDto;
import com.example.dolbomi.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public void register(RegisterRequestDto dto) {
        Long oldIndex = dto.getOldIndex();
        Long adminIndex = dto.getAdminIndex();
        adminRepository.insertUserAdmin(oldIndex, adminIndex);
    }

}
