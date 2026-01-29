package com.shopshere.UserService.service;

import com.shopshere.UserService.dto.request.UserRegistrationRequest;
import com.shopshere.UserService.dto.response.UserResponseDTO;

public interface UserService {

    UserResponseDTO registerUser(UserRegistrationRequest userRegistrationRequest);
}
