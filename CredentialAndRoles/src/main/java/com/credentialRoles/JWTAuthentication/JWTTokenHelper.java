package com.credentialRoles.JWTAuthentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

@Component
public class JWTTokenHelper {

    private final String SECRET_KEY = Jwts.SIG.HS256.key().build().toString(); // Use environment variables in production
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // Generate JWT Token
    public String generateToken(String username) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key) // Use SecretKey instead of raw string
                .compact();
    }

    // Validate JWT Token
    public boolean validateToken(String token, String username) {
        String tokenUsername = extractUsername(token);
        return (username.equals(tokenUsername) && !isTokenExpired(token));
    }

    // Extract username from token
    public String extractUsername(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    // Check if token is expired
    private boolean isTokenExpired(String token) {
        return getClaimsFromToken(token).getExpiration().before(new Date());
    }

    // Get claims from token
    private Claims getClaimsFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
