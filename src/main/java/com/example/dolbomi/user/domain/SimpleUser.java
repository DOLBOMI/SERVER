package com.example.dolbomi.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class SimpleUser {

    @NotNull
    private Integer userIndex;

    @NotNull
    private String name;

    @NotNull
    private Integer registerNo;

    @NotNull
    private Integer status;

    @Builder
    public SimpleUser(Integer userIndex, String name, Integer registerNo, Integer status) {
        this.userIndex = userIndex;
        this.name = name;
        this.registerNo = registerNo;
        this.status = status;
    }
}