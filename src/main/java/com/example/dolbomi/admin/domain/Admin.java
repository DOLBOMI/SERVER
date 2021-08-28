package com.example.dolbomi.admin.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Admin {

    private String adminName;
    private String adminPhoneNo;
    private String password;

    @Builder
    public Admin(String adminName, String adminPhoneNo, String password) {
        this.adminName = adminName;
        this.adminPhoneNo = adminPhoneNo;
        this.password = password;
    }
}
