package com.social.circle.services;

import com.social.circle.dto.UserLoginRequest;
import com.social.circle.dto.UserResponse;
import com.social.circle.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {

    Optional<UserResponse> register(User userDetails);

    Optional<UserResponse> login(UserLoginRequest loginRequest);
}
