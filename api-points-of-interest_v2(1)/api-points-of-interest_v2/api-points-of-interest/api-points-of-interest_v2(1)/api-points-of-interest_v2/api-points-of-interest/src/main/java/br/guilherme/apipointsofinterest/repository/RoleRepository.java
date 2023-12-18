package br.guilherme.apipointsofinterest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.guilherme.apipointsofinterest.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
