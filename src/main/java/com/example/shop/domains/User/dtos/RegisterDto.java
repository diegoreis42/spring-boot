package com.example.shop.domains.User.dtos;

import com.example.shop.domains.User.UserRolesEnum;

public record RegisterDto(String email, String password, UserRolesEnum role) {

}
