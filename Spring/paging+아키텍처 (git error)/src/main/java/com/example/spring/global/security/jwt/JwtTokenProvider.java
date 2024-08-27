package com.example.spring.global.security.jwt;

import com.example.spring.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.spring.domain.auth.domain.RefreshToken;
import com.example.spring.domain.auth.exception.ExpiredTokenException;
import com.example.spring.domain.auth.exception.InValidTokenException;
import com.example.spring.domain.user.domain.repository.UserRepository;
import com.example.spring.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;



import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    private final UserRepository userRepository;

    private final AuthDetailsService authDetailsService;

    private final RefreshTokenRepository refreshTokenRepository;

    public String createAccessToken(String accountId) {

        Date now = new Date();

        return Jwts.builder()
                .setSubject(accountId)
                .claim("type", "access")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+jwtProperties.getAccessExpiration() * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
    }

    public String createRefreshToken(String accountId){

        Date now = new Date();

        String refreshToken = Jwts.builder()
                .setSubject(accountId)
                .claim("type", "refresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+jwtProperties.getRefreshExpiration() * 1000))
                .compact();

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .accountId(accountId)
                        .token(refreshToken)
                        .timeToLive((jwtProperties.getRefreshExpiration()))
                        .build());
        return refreshToken;
    }

    public Authentication getAuthentication(String token){
        Claims claims = getClaims(token);
        UserDetails userDetails =authDetailsService.loadUserByAccountId(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());

    }

    public Claims getClaims(String token){

        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException e){
            throw ExpiredTokenException.EXCEPTION;
        }catch (Exception e){
            throw InValidTokenException.EXCEPTION;
        }
    }

    public






}
