package com.symbiosis.app.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtProvider {
    private static final String BEARER = "Bearer ";
    private static final String HEADER = HttpHeaders.AUTHORIZATION;

    @Value("${jwt.secret: d214y124eh1upr}")
    private String secretKey;

    @Value("${jwt.expiration: 3600000}")
    private Long expiration;

    public String generateToken(String subject, Collection<? extends GrantedAuthority> roles) {
        Date date = new Date();
        Claims claims = Jwts.claims();
        claims.put("roles",
                roles
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        return Jwts
                .builder()
                .setSubject(subject)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + expiration))
                .setClaims(claims)
                .setIssuer("Symbiosis")
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateToken(Jws<Claims> claims) {
        try {
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException e) {
            return false;
        }
    }

    public Jws<Claims> resolveToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String header = request.getHeader(HEADER);

        if (header == null || !header.startsWith(BEARER)) {
            return null;
        }

        String token = header.substring(BEARER.length());
        try {
            Jws<Claims> claims = resolveToken(token);
            if (!validateToken(claims)) {
                return null;
            }
            return new UsernamePasswordAuthenticationToken(
                    claims.getBody().getSubject(),
                    null,
                    Arrays.stream(claims.getBody().get("roles", String[].class))
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList()));
        } catch (JwtException e) {
            return null;
        }

    }

}
