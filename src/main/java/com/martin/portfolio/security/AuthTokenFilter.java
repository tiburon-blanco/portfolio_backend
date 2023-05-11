package com.martin.portfolio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(String.valueOf(SecurityConstant.HEADER_AUTHORIZATION_KEY));
        if (header == null || !header.startsWith(String.valueOf(SecurityConstant.TOKEN_PREFIX))) {
            filterChain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }


    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(String.valueOf(SecurityConstant.HEADER_AUTHORIZATION_KEY));

        if (token != null) {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token.replace(String.valueOf(SecurityConstant.TOKEN_PREFIX), "")).getBody();

            Collection<? extends GrantedAuthority> authorities = new ArrayList<>();

            if (claims != null) {
                int id = Integer.parseInt(claims.getSubject());
                SecurityUser principal = new SecurityUser(claims.getSubject(), "", authorities, id);
                return new UsernamePasswordAuthenticationToken(principal, null, authorities);
            }
        }
        return null;
    }

    private Key getSigningKey() {
        byte[] keyBytes = this.jwtSecretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}