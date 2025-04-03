package com.credentialRoles.JWTAuthentication;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class JWTAuthResponse {
    private String token;
}
