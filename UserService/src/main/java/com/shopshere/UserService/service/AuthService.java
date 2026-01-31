package com.shopshere.UserService.service;

import com.shopshere.UserService.dto.request.LoginRequestDTO;
import com.shopshere.UserService.dto.response.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO loginUser);
}
