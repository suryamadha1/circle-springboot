package com.social.circle.controllers;
import com.social.circle.dto.MessageResponse;
import com.social.circle.dto.UserLoginRequest;
import com.social.circle.dto.UserResponse;
import com.social.circle.entities.User;
import com.social.circle.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User userDetails) {
        Optional<UserResponse> registerResponse = userService.register(userDetails);
        if(registerResponse.isEmpty()){
            return new ResponseEntity<MessageResponse>(new MessageResponse("User already exists"), HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(registerResponse.stream().collect(Collectors.toList()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest loginRequest){
        Optional<UserResponse> loginResponse = userService.login(loginRequest);
        return new ResponseEntity<MessageResponse>(new MessageResponse("Login Successful"), HttpStatus.OK);
    }
}
