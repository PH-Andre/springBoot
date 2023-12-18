package br.guilherme.apipointsofinterest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.guilherme.apipointsofinterest.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(Object subject); 
}
