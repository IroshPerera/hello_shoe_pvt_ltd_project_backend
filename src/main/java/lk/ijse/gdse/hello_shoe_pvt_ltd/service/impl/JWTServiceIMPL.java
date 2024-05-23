package lk.ijse.gdse.hello_shoe_pvt_ltd.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lk.ijse.gdse.hello_shoe_pvt_ltd.service.JWTService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServiceIMPL implements JWTService {

    @Value("${token.key}")
    private String jwtKey;
    @Override
    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(),userDetails);
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }



    //actual process
    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
       final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private String generateToken(Map<String,Object> extractClaim,UserDetails userDetails) {

        extractClaim.put("role",userDetails.getAuthorities());
        Date now = new Date();
        //expire time 24 hours and set refresh token
        Date expire = new Date(now.getTime() + 1000 * 60 * 60 * 24);
        String accessToken = Jwts.builder().setClaims(extractClaim)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact() + " : " +
                Jwts.builder().setClaims(extractClaim)
                        .setSubject(userDetails.getUsername())
                        .setIssuedAt(now)
                        .setExpiration(new Date(now.getTime() + 1000 * 60 * 60))
                        .signWith(getSignKey(),SignatureAlgorithm.HS256).compact();

        return accessToken;
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());

    }

    private Claims getAllClaims(String token) {
     return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();

    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
    private Key getSignKey() {
        byte[] decode = Decoders.BASE64.decode(jwtKey);
        return Keys.hmacShaKeyFor(decode);
    }
}
