package com.example.twitterclone.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtProvider {
    public String generateToken(Authentication authentication){
        String secretKey = "secret_key";
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 600000))
                .claim("email",authentication.getName())
                .signWith(key)
                .compact();
    }

    public String getEmailFromToken(String jwt){
        String secretKey = "secret_key";

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        Claims claims= Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(jwt).getBody();
        return String.valueOf(claims.get("email"));
    }

}
