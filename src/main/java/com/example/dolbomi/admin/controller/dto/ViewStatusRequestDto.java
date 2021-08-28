package com.example.dolbomi.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ViewStatusRequestDto {

    @NotNull(message = "관리자 인덱스를 입력해주세요")
    private Long adminIndex;

    @NotNull(message = "사용자 상태를 입력해주세요")
    private Long status;

    @Builder
    public ViewStatusRequestDto(Long adminIndex, Long status) {
        this.adminIndex = adminIndex;
        this.status=status;
    }
}