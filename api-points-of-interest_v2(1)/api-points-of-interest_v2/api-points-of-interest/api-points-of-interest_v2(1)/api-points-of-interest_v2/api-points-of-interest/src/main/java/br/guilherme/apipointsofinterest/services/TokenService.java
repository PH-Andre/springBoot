package br.guilherme.apipointsofinterest.services;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    // Inicializa um logger para registrar informações do serviço de tokens.
    Logger logger = Logger.getLogger(TokenService.class.getName());

    // Cria um token JWT com base nas informações do usuário.
    public String createJwt(UserDetailsImpl user) {

        // Registra uma mensagem no logger.
        logger.info("createJwt");

        return JWT.create()
                .withSubject(user.getUsername()) // Define o assunto do token como o nome de usuário.
                .withIssuer("api-rest-spring-boot") // Define o emissor do token.
                .withExpiresAt(Date.from(Instant.now().plus(Duration.ofMinutes(15)))) // Define a data de expiração do token.
                .sign(Algorithm.HMAC256("desenvolvimento")); // Assina o token com um segredo (HMAC256).
    }

    // Obtém o assunto (subject) de um token JWT.
    public String getSubject(String token) {

        // Registra uma mensagem no logger.
        logger.info("getSubject");

        return JWT.require(Algorithm.HMAC256("desenvolvimento")) // Define o algoritmo de verificação.
                .withIssuer("api-rest-spring-boot") // Define o emissor esperado.
                .build()
                .verify(token) // Verifica o token.
                .getSubject(); // Obtém o assunto (subject) do token.
    }
}
