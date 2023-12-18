package br.guilherme.apipointsofinterest.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       
        http.httpBasic(Customizer.withDefaults());

        http
        .csrf(Customizer -> {
            Customizer.disable();
        })
        .authorizeHttpRequests(Customizer -> {
            Customizer
            .requestMatchers("/api/v1/phfinanceira/login").permitAll() // Permite acesso público.
            .requestMatchers("/api/v1/phfinanceira").hasRole("USER") // Requer a função "USER".
            .anyRequest().authenticated(); 
        });

     
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



     // Configura o gerenciador de autenticação.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configurAuthentication) throws Exception {
        return configurAuthentication.getAuthenticationManager();
    } 
}
