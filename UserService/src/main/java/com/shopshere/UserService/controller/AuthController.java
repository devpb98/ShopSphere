package com.shopshere.UserService.controller;

import com.shopshere.UserService.dto.request.LoginRequestDTO;
import com.shopshere.UserService.dto.response.ApiResponse;
import com.shopshere.UserService.dto.response.LoginResponseDTO;
import com.shopshere.UserService.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(
            @Valid @RequestBody LoginRequestDTO request) {

        LoginResponseDTO loginResponseDTO = authService.login(request); // success if no exception

        ApiResponse<LoginResponseDTO> response = ApiResponse.<LoginResponseDTO>builder()
                .status("SUCCESS")
                .message("Login successful")
                .data(loginResponseDTO)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}