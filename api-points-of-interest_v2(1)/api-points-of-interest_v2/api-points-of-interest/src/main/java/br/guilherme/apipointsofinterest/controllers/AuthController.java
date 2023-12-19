package br.guilherme.apipointsofinterest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.guilherme.apipointsofinterest.DTOs.LoginDTO;
import br.guilherme.apipointsofinterest.security.UserDetailsImpl;
import br.guilherme.apipointsofinterest.services.TokenService;


@RestController
@RequestMapping("api/v1/phautentic")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

   
    
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        try {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password()));
        var user = (UserDetailsImpl) authenticate.getPrincipal();

        return tokenService.createJwt(user);
         } catch (Exception e) {
            return "Erro de autenticação: " + e.getMessage();
        }
    }
}
