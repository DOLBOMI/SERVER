package com.example.dolbomi.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class RegisterRequestDto {

    @NotNull(message = "노인 인덱스를 입력해주세요")
    private Long oldIndex;

    @NotNull(message = "관리자 인덱스를 입력해주세요")
    private Long adminIndex;

    @Builder
    public RegisterRequestDto(Long oldIndex, Long adminIndex) {
        this.oldIndex = oldIndex;
        this.adminIndex = adminIndex;
    }

}
