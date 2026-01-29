package com.shopshere.UserService.controller;

import com.shopshere.UserService.dto.request.LoginRequestDTO;
import com.shopshere.UserService.dto.request.UserRegistrationRequest;
import com.shopshere.UserService.dto.response.ApiResponse;
import com.shopshere.UserService.dto.response.LoginResponseDTO;
import com.shopshere.UserService.dto.response.UserResponseDTO;
import com.shopshere.UserService.service.AuthService;
import com.shopshere.UserService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "OK";
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> registerUser(@Valid @RequestBody UserRegistrationRequest user) {

        UserResponseDTO userResponse = userService.registerUser(user);

        ApiResponse<UserResponseDTO> response = ApiResponse.<UserResponseDTO>builder()
                .status("SUCCESS")
                .message("User registered successfully")
                .data(userResponse)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
