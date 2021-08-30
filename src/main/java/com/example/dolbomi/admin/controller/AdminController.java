package com.example.dolbomi.admin.controller;

import com.example.dolbomi.admin.controller.dto.*;
import com.example.dolbomi.admin.service.AdminService;
import com.example.dolbomi.global.auth.AuthRequired;
import com.example.dolbomi.global.auth.LoginType;
import com.example.dolbomi.global.common.StatusEnum;
import com.example.dolbomi.global.common.SuccessResponse;
import com.example.dolbomi.user.domain.SimpleUser;
import com.example.dolbomi.user.service.SessionLoginService;

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
    private final SessionLoginService sessionLoginService;

    @AuthRequired(type = LoginType.ADMIN)
    @GetMapping("/status")
    public SuccessResponse viewAll() {
        Integer adminRegisterNo = sessionLoginService.getAdminRegisterNo();
        List<SimpleUser> arr = adminService.viewAll(adminRegisterNo);
        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("전체 조회 성공")
                .data(arr)
                .build();
        return res;
    }

    @AuthRequired(type = LoginType.ADMIN)
    @GetMapping("/status/i={oldIndex}")
    public SuccessResponse viewOld(@PathVariable("oldIndex") Integer oldI) {
        Integer adminRegisterNo = sessionLoginService.getAdminRegisterNo();
        List<SimpleUser> arr = adminService.viewOld(adminRegisterNo, oldI);

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("개별 조회 성공")
                .data(arr)
                .build();
        return res;
    }

    @AuthRequired(type = LoginType.ADMIN)
    @GetMapping("/status/s={status}")
    public SuccessResponse viewStatus(@PathVariable("status") Integer s) {
        Integer adminRegisterNo = sessionLoginService.getAdminRegisterNo();
        List<SimpleUser> arr = adminService.viewStatus(adminRegisterNo, s);

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("상태별 조회 성공")
                .data(arr)
                .build();
        return res;
    }

    @AuthRequired(type = LoginType.ADMIN)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public SuccessResponse register(@Valid @RequestBody final RegisterRequestDto requestDto) {
        Integer adminRegisterNo = sessionLoginService.getAdminRegisterNo();
        adminService.register(requestDto, adminRegisterNo);

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("노인 등록 성공")
                .build();
        return res;
    }

    @AuthRequired(type = LoginType.ADMIN)
    @DeleteMapping("/delete")
    public SuccessResponse delete(@Valid @RequestBody final DeleteRequestDto requestDto) {
        Integer adminRegisterNo = sessionLoginService.getAdminRegisterNo();
        adminService.delete(requestDto, adminRegisterNo);

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("노인 삭제 성공")
                .build();
        return res;
    }

    @AuthRequired(type = LoginType.ADMIN)
    @PutMapping("/{idx}/status")
    public SuccessResponse changeStatus(@PathVariable("idx") Integer idx, @Valid @RequestBody final ChangeRequestDto requestDto) {
        Integer adminRegisterNo = sessionLoginService.getAdminRegisterNo();
        adminService.changeStatus(idx, adminRegisterNo, requestDto);

        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("노인 상태 변경 성공")
                .build();
        return res;
    }
}
