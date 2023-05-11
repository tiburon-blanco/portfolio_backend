package com.martin.portfolio.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class TokenProvider {

    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    public String create(Authentication authentication) {
        String userId = String.valueOf(((SecurityUser)authentication.getPrincipal()).getId());
        SecretKey key = Keys.hmacShaKeyFor(jwtSecretKey.getBytes());
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject(userId)
                //.setExpiration(new Date(System.currentTimeMillis() + SecurityConstant.TOKEN_EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
