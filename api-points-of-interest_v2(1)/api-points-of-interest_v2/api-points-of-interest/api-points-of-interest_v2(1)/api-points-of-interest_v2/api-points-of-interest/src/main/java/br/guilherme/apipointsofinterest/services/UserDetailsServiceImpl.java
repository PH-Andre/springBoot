package br.guilherme.apipointsofinterest.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.guilherme.apipointsofinterest.entities.User;
import br.guilherme.apipointsofinterest.repository.UserRepository;
import br.guilherme.apipointsofinterest.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username)  {
        
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        
        return new UserDetailsImpl(user);

    }
}
