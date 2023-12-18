package br.guilherme.apipointsofinterest.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.guilherme.apipointsofinterest.DTOs.ClienteDTO;

import br.guilherme.apipointsofinterest.DTOs.ClienteCreditosDTO;
import br.guilherme.apipointsofinterest.entities.Cliente;
import br.guilherme.apipointsofinterest.exceptions.ClienteBloqueadoException;
import br.guilherme.apipointsofinterest.services.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/phfinanceira")
@Validated
public class ClienteController {

    Logger logger = Logger.getLogger(ClienteController.class.getName());

    @Autowired
    private ClienteService ClienteService;

    @GetMapping("private/clientes")
    public ResponseEntity<List<Cliente>> ListarCliente() {
        var cliente = ClienteService.ListarCliente();

        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping("private/consulta")
    public ResponseEntity<ClienteCreditosDTO> consulta(@RequestBody @Valid ClienteDTO clienteDTO) {
        var responseCredito = new ClienteCreditosDTO(); 
        var cliente = Cliente.convert(clienteDTO);

        if (ClienteService.BloqueiaCliente(cliente)){
            throw new ClienteBloqueadoException();
        }

        responseCredito = ClienteService.listarCreditos(cliente);

        return ResponseEntity.created(null).body(responseCredito);
    }

}
