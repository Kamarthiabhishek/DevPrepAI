package com.devprep.devprepai.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.expiration}")
    private long expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String email){

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .subject(email)
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(getSigningKey()).compact();
    }

    public SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }


    public Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    public String extractEmail(String token){
        return extractAllClaims(token).getSubject();
    }

    public Date  extractExpiration(String token){
        return extractAllClaims(token).getExpiration();
    }

    public Date extractIssuedAt(String token){
        return extractAllClaims(token).getIssuedAt();
    }
}
