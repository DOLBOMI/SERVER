package com.example.dolbomi.admin.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Admin {

    private String name;
    private String adminPhoneNo;
    private String password;
    private Integer registerNo;

    @Builder
    public Admin(String name, String adminPhoneNo, String password, Integer registerNo) {
        this.name = name;
        this.adminPhoneNo = adminPhoneNo;
        this.password = password;
        this.registerNo = registerNo;
    }
}
