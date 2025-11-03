package org.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtils {
  
  private static final String SECRET_KEY = "{secretKey}";
  
  public static String generateToken(String userId) {
    return Jwts.builder()
        .claim("userId", userId)
        .setIssuedAt(new Date())
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();
  }
  
  public static String getUserIdFromJWT(String JWT) {
    return Jwts.parser()
        .setSigningKey(SECRET_KEY)
        .build()
        .parseClaimsJws(JWT)
        .getBody()
        .get("userId", String.class);
  }
}