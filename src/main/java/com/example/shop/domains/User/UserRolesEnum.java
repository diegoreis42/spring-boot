package com.example.shop.domains.User;

import lombok.Getter;

@Getter
public enum UserRolesEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

     UserRolesEnum(String role) {
        this.role = role;
    }
}
