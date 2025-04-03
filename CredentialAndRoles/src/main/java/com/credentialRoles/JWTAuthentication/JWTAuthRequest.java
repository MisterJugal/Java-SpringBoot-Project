package com.credentialRoles.JWTAuthentication;

import lombok.Data;

@Data
public class JWTAuthRequest {


    private String username;
    private String password;

}
