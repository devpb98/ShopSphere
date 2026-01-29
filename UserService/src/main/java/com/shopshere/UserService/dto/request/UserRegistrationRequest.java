package com.shopshere.UserService.dto.request;

import com.shopshere.UserService.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserRegistrationRequest {

    @NotBlank(message = "first name should not be empty.")
    private String firstName;

    @NotBlank(message = "last name should not be empty.")
    private String lastName;

    @Email(message = "Email should be valid.")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotEmpty(message = "At least one role should be provided.")
    private Set<String> roles;

    @NotBlank(message = "Password should not be empty")
    @Size(min = 8, max = 20, message = "Password length should be 6-20.")
    private String password;



}
