package com.shopshere.UserService.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDTO {

    private String accessToken;
    private String tokenType;

    public LoginResponseDTO(String token){
        this.accessToken = token;
        this.tokenType = "Bearer";
    }

}
