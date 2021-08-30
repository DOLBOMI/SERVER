package com.example.dolbomi.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ViewAllRequestDto {

    @NotNull(message = "관리자 인덱스를 입력해주세요")
    private Long adminIndex;

    @Builder
    public ViewAllRequestDto(Long adminIndex) {
        this.adminIndex = adminIndex;
    }
}