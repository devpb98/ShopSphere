package com.shopshere.UserService.service.impl;

import com.shopshere.UserService.dto.request.LoginRequestDTO;
import com.shopshere.UserService.entity.User;
import com.shopshere.UserService.exception.ResourceNotFoundException;
import com.shopshere.UserService.repositories.UserRepository;
import com.shopshere.UserService.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void login(LoginRequestDTO loginUser) {

        User user = userRepository.findByEmail(loginUser.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));

        if (!passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

    }
}
