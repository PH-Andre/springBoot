package br.guilherme.apipointsofinterest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.guilherme.apipointsofinterest.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {}
