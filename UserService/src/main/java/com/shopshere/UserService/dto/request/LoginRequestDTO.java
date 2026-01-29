package com.shopshere.UserService.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

    @Email(message = "Email should be valid.")
    @NotBlank(message = "Email can't be blank.")
    private String email;

    @NotBlank(message = "password can't be blank")
    @Size(min = 8, max = 20, message = "Password length should be 8-20.")
    private String password;


}
