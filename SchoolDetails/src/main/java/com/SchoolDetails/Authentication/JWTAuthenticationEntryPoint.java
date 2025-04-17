package com.SchoolDetails.Authentication;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "This use is not present in our data base");
                //throw new UsernameNotFoundException(" exception from 'JWTAuthenticationEntryPoint' ");
    }

}
