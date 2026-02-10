package com.ekate.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    // Убрать в .env
    private final String SECRET = "34frvdce44543tgfcw322tfwe224y45re";

    public String generateToken(String uuid,boolean isAdmin) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("isAdmin",isAdmin);
        claims.put("uuid",uuid);
        return Jwts.builder()
                .addClaims(claims)
                .setSubject(uuid)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 день
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public Map<String,Object> getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

