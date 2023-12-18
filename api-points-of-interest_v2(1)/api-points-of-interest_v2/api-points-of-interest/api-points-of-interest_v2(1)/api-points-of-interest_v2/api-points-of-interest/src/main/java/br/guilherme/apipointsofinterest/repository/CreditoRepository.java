package br.guilherme.apipointsofinterest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.guilherme.apipointsofinterest.entities.Credito;

public interface CreditoRepository extends JpaRepository<Credito, Long> {}
