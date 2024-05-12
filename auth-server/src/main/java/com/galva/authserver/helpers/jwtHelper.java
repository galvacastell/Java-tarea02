package com.galva.authserver.helpers;


import com.galva.authserver.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;
import javax.crypto.SecretKey;

@Component
@Slf4j
public class jwtHelper {
    @Value("${application.jwt.secret}")
    private String jwtSecret;

    public String creatToken(String user)
    {
        final var now = new Date();
        final var expirationDate = new Date(now.getTime()+(3600*1000));
        return Jwts
                .builder()
                .setSubject(user)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(this.getSecretKey())
                .compact();
    }

    public boolean validateToken(String token)
    {
        final var expirationDate = this.getExpirationDate(token);
        return expirationDate.after(new Date());
    }

    private Date getExpirationDate(String token)
    {
        return this.getClaimsFromToken(token,Claims::getExpiration);
    }

    private <T> T getClaimsFromToken(String token,Function<Claims, T> resolver)
    {
        return resolver.apply(this.signToken(token));
    }

    private Claims signToken(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(this.getSecretKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();

    }

    private SecretKey getSecretKey()
    {
        return Keys.hmacShaKeyFor(this.jwtSecret.getBytes(StandardCharsets.UTF_8));

    }
}
