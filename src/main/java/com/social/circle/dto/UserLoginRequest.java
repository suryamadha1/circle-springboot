package com.social.circle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class UserLoginRequest {
    private String email;
    private String password;
}
