package com.example.dolbomi.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class RegisterRequestDto {

    @NotNull(message = "노인 등록번호를 입력해주세요")
    private Integer registerNo;

    @NotNull(message = "관리자 인덱스를 입력해주세요")
    private Integer adminIndex;

    @Builder
    public RegisterRequestDto(Integer registerNo, Integer adminIndex) {
        this.registerNo = registerNo;
        this.adminIndex = adminIndex;
    }
}
