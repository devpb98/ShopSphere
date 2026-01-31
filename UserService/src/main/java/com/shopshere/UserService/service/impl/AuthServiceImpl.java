package com.shopshere.UserService.service.impl;

import com.shopshere.UserService.dto.request.LoginRequestDTO;
import com.shopshere.UserService.dto.response.LoginResponseDTO;
import com.shopshere.UserService.entity.Role;
import com.shopshere.UserService.entity.User;
import com.shopshere.UserService.exception.ResourceNotFoundException;
import com.shopshere.UserService.repositories.UserRepository;
import com.shopshere.UserService.security.JwtUtil;
import com.shopshere.UserService.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginUser) {

        User user = userRepository.findByEmail(loginUser.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));

        if (!passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList()));

        String token = jwtUtil.generateToken(user.getEmail(),  claims);
        return new LoginResponseDTO(token);

    }
}
