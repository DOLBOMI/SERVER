package com.example.dolbomi.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class DeleteRequestDto {

    @NotNull(message = "노인 인덱스를 입력해주세요")
    private Integer oldIndex;

    @NotNull(message = "관리자 인덱스를 입력해주세요")
    private Integer adminIndex;

    @Builder
    public DeleteRequestDto(Integer oldIndex, Integer adminIndex) {
        this.oldIndex = oldIndex;
        this.adminIndex = adminIndex;
    }
}
