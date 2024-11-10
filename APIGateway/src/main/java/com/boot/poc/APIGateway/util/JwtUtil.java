package com.boot.poc.APIGateway.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    public static final String SECRET = "4c150338ceb833c0ce5129067decb18aa5f0880331e392dfc27d2e87e2d074ba";


    public void validateToken(final String token){
        Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token);
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
