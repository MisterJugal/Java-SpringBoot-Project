package com.credentialRoles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credentialRoles.JWTAuthentication.JWTAuthRequest;
import com.credentialRoles.JWTAuthentication.JWTAuthResponse;
import com.credentialRoles.JWTAuthentication.JWTTokenHelper;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenHelper jwtTokenHelper;

    @Autowired
    private JWTAuthResponse jwtAuthResponse;

    @PostMapping("/login")
    ResponseEntity<JWTAuthResponse> login(@RequestBody JWTAuthRequest request) {

        Authentication auth = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        authenticationManager.authenticate(auth);

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());

        String token = jwtTokenHelper.generateToken(user.getUsername());

        jwtAuthResponse.setToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

}
