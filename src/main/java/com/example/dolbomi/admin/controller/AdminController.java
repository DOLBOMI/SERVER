package com.example.dolbomi.admin.controller;

import com.example.dolbomi.admin.controller.dto.*;
import com.example.dolbomi.admin.service.AdminService;
import com.example.dolbomi.global.common.StatusEnum;
import com.example.dolbomi.global.common.SuccessResponse;
import com.example.dolbomi.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/admins")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @Cacheable
    @GetMapping("/status")
    public SuccessResponse viewAll(@Valid @RequestBody final ViewAllRequestDto requestDto) {
        List<User> arr = new ArrayList<>();
        arr = adminService.viewAll(requestDto);

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("전체 조회 성공")
                .data(arr)
                .build();
        return res;
    }

    @Cacheable
    @GetMapping("/status/{oldIndex}")
    public SuccessResponse viewOld(@Valid @RequestBody final ViewRequestDto requestDto) {
        List<User> arr = new ArrayList<>();
        arr = adminService.viewOld(requestDto);

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("개별 조회 성공")
                .data(arr)
                .build();
        return res;
    }

    @Cacheable
    @GetMapping("")
    public SuccessResponse viewStatus(@Valid @RequestBody final ViewStatusRequestDto requestDto) {
        List<User> arr = new ArrayList<>();
        arr = adminService.viewStatus(requestDto);

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