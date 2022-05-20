package com.inmon.restapi.config.security;

import com.inmon.restapi.entity.member.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {
    public static final Key signatureKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static final long JWT_TOKEN_VALIDITY = 5*60*60;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getId);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(signatureKey)
                .parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public String generateToken(String id) {
        return generateToken(id, new HashMap<>());
    }

    public String generateToken(String id, Map<String, Object> claims) {
        return doGenerateToken(id, claims);
    }

    private String doGenerateToken(String id, Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject("users/TzMUocMF4p")
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .claim("id",id)
                .setId(id)
                .signWith(signatureKey)
                .compact();
    }

    public Boolean validateToken(String token, Member member) {
        final String username = getUsernameFromToken(token);
        return (username.equals(member.getUserId())) && !isTokenExpired(token);
    }
}
