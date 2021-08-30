package com.example.dolbomi.admin.controller.dto;

import lombok.Builder;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.NotNull;

@Getter
public class ChangeRequestDto {

    @NotNull(message = "상태 인덱스를 입력해주세요")
    private Integer status;

    @Builder
    public ChangeRequestDto(@JsonProperty("status") Integer status) {
        this.status = status;
    }

    @Builder
    public ChangeRequestDto() {

    }
}
