package br.guilherme.apipointsofinterest.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.guilherme.apipointsofinterest.DTOs.CreditoDTO;
import br.guilherme.apipointsofinterest.entities.Credito;
import br.guilherme.apipointsofinterest.entities.Cliente;
import br.guilherme.apipointsofinterest.repository.ClienteRepository;
//import br.guilherme.apipointsofinterest.exceptions.PointNotFoundException;
import br.guilherme.apipointsofinterest.repository.CreditoRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository CreditoRepository;

    Logger logger = Logger.getLogger(CreditoService.class.getName());

    public List<Credito> ListarCreditos() {
        List<Credito> Creditos = CreditoRepository.findAll();
        return Creditos;
    }

}