package br.guilherme.apipointsofinterest.services;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import br.guilherme.apipointsofinterest.security.UserDetailsImpl;

@Service
public class TokenService {

   
    Logger logger = Logger.getLogger(TokenService.class.getName());

    public String createJwt(UserDetailsImpl user) {

        logger.info("createJwt");

        return JWT.create()
                .withSubject(user.getUsername()) 
                .withIssuer("api-rest-spring-boot") 
                .withExpiresAt(Date.from(Instant.now().plus(Duration.ofMinutes(15))))
                .sign(Algorithm.HMAC256("desenvolvimento")); 
    }

   
    public String getSubject(String token) {

        logger.info("getSubject");

        return JWT.require(Algorithm.HMAC256("desenvolvimento"))
                .withIssuer("api-rest-spring-boot")
                .build()
                .verify(token) 
                .getSubject(); 
    }
}
