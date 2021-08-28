package com.example.dolbomi.admin.controller;

import com.example.dolbomi.admin.controller.dto.*;
import com.example.dolbomi.admin.service.AdminService;
import com.example.dolbomi.global.common.StatusEnum;
import com.example.dolbomi.global.common.SuccessResponse;
import com.example.dolbomi.user.domain.SimpleUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admins")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/status")
    public SuccessResponse viewAll() {
        List<SimpleUser> arr = adminService.viewAll();

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("전체 조회 성공")
                .data(arr)
                .build();
        return res;
    }

    @GetMapping("/status/{oldIndex}")
    public SuccessResponse viewOld() {
        List<SimpleUser> arr = adminService.viewOld();

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("개별 조회 성공")
                .data(arr)
                .build();
        return res;
    }

    @GetMapping("")
    public SuccessResponse viewStatus() {
        List<SimpleUser> arr = adminService.viewStatus();

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("상태별 조회 성공")
                .data(arr)
                .build();
        return res;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public SuccessResponse register(@Valid @RequestBody final RegisterRequestDto requestDto) {
        adminService.register(requestDto);
        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("노인 등록 성공")
                .build();
        return res;
    }
}