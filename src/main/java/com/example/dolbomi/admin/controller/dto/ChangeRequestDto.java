package com.example.dolbomi.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ChangeRequestDto {

    @NotNull(message = "관리자 인덱스를 입력해주세요")
    private Long adminIndex;

    @NotNull(message = "상태 인덱스를 입력해주세요")
    private Long status;

    @Builder
    public ChangeRequestDto(Long adminIndex, Long status) {
        this.adminIndex = adminIndex;
        this.status = status;
    }

}
