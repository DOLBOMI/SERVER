package com.example.dolbomi.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class DeleteRequestDto {

    @NotNull(message = "노인 인덱스를 입력해주세요")
    private Integer oldIndex;

    @Builder
    public DeleteRequestDto(Integer oldIndex) {
        this.oldIndex = oldIndex;
    }
}
