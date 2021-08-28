package com.example.dolbomi.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ViewRequestDto {

    @NotNull(message = "노인 인덱스를 입력해주세요")
    private Long oldIndex;

    @Builder
    public ViewRequestDto(Long oldIndex) {
        this.oldIndex = oldIndex;
    }
}