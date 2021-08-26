package com.example.dolbomi.admin.controller;

import com.example.dolbomi.admin.controller.dto.*;
import com.example.dolbomi.admin.service.AdminService;
import com.example.dolbomi.global.common.StatusEnum;
import com.example.dolbomi.global.common.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/admins")
@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

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

    @DeleteMapping("/delete")
    public SuccessResponse delete(@Valid @RequestBody final DeleteRequestDto requestDto) {
        adminService.delete(requestDto);
        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("노인 삭제 성공")
                .build();
        return res;
    }

    @PutMapping("/{idx}/status")
    public SuccessResponse changeStatus(@PathVariable(name = "idx") @Valid @RequestBody final ChangeRequestDto requestDto) {
        adminService.changeStatus(requestDto);
        SuccessResponse res = SuccessResponse.builder()
                .status(StatusEnum.CREATED)
                .message("노인 상태 변경 성공")
                .build();
        return res;
    }

}
