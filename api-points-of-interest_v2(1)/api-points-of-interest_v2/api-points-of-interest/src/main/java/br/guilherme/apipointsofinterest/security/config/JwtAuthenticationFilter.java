package br.guilherme.apipointsofinterest.security.config;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.guilherme.apipointsofinterest.entities.User;
import br.guilherme.apipointsofinterest.security.UserDetailsImpl;
import br.guilherme.apipointsofinterest.services.TokenService;
import  br.guilherme.apipointsofinterest.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // Inicializa um logger para registrar informações do filtro.
    Logger logger = Logger.getLogger(JwtAuthenticationFilter.class.getName());

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Registra uma mensagem no logger.
        logger.info("doFilterInternal");

        String token;

        // Obtém o cabeçalho de autorização da requisição HTTP.
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null) {
            // Remove o prefixo "Bearer " do token JWT.
            token = authorizationHeader.replace("Bearer ", "");
            
            // Extrai o assunto (subject) do token JWT, que é o nome de usuário.
            var subject = tokenService.getSubject(token);

            // Busca o usuário correspondente ao nome de usuário no banco de dados.
            User user = userRepository.findByUsername(subject)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Cria um objeto UserDetailsImpl com informações do usuário.
            var userDetails = new UserDetailsImpl(user);

            // Cria uma instância de UsernamePasswordAuthenticationToken para autenticação.
            var authentication = new UsernamePasswordAuthenticationToken(user, null, userDetails.getAuthorities());

            // Define a autenticação no contexto de segurança do Spring.
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // Continua o processamento da requisição.
        filterChain.doFilter(request, response);
    }
}
