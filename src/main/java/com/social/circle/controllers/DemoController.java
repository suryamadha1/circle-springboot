package com.social.circle.controllers;

import com.social.circle.dto.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/")
    public ResponseEntity<MessageResponse> index() {
        return ResponseEntity.ok(new MessageResponse("Hello"));
    }
}
