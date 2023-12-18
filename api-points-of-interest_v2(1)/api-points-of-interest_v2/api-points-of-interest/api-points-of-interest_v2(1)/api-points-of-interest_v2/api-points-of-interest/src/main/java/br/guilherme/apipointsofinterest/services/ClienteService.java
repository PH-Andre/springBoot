package br.guilherme.apipointsofinterest.services;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import br.guilherme.apipointsofinterest.DTOs.ClienteCreditosDTO;
import br.guilherme.apipointsofinterest.controllers.ClienteController;
import br.guilherme.apipointsofinterest.entities.Cliente;
import br.guilherme.apipointsofinterest.entities.Credito;
import br.guilherme.apipointsofinterest.repository.ClienteRepository;
import br.guilherme.apipointsofinterest.repository.CreditoRepository;
import lombok.experimental.var;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

//import br.guilherme.apipointsofinterest.exceptions.ClienteNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository ClienteRepository;
    @Autowired
    private CreditoRepository CreditoRepository;

    Logger logger = Logger.getLogger(ClienteService.class.getName());

    public void ConsultarCliente(Cliente cliente) {
        var clientes = ClienteRepository.findById(cliente.getCpf());

        if (clientes.isPresent()) {
            Cliente clienteExistente = clientes.get();
            clienteExistente.setAge(cliente.getAge());
            clienteExistente.setIncome(cliente.getIncome());
            clienteExistente.setLocation(cliente.getLocation());

            ClienteRepository.save(clienteExistente);
        }else{
            ClienteRepository.save(cliente);
        }
    }

    public List<Credito> validarCreditos(Cliente cliente, List<Credito> creditos ){

        List<Credito> disponiveis = new ArrayList<Credito>(); 
        double clienteSalario = cliente.getIncome();

        for (Credito credito : creditos) {
            String creditoTipo = credito.getTipo();

            if (creditoTipo.equals("Pessoal") || creditoTipo.equals("Garantido")) {

                if (clienteSalario <= 3000 || (clienteSalario > 3000 && clienteSalario < 5000 && cliente.getAge() < 30  && cliente.getLocation().equals("RS"))) {
                    disponiveis.add(credito);
                }   
            }
            else if(creditoTipo.equals("Consignado")){
                if (clienteSalario >= 5000){
                    disponiveis.add(credito);
                }
            }
        }

        return disponiveis;
    }

    public ClienteCreditosDTO listarCreditos(Cliente cliente) {
        ClienteCreditosDTO responseCredito = new ClienteCreditosDTO();
        responseCredito.setNome(cliente.getName());
    
        ConsultarCliente(cliente);
        List<Credito> listadecreditos = CreditoRepository.findAll();
        List<Credito> creditosDisponiveis = validarCreditos(cliente, listadecreditos);


        
        responseCredito.setCreditos(creditosDisponiveis);
        return responseCredito;
    }

    public List<Cliente> ListarCliente() {
        List<Cliente> clientes = ClienteRepository.findAll();

        return clientes;
    }

    public Boolean BloqueiaCliente(Cliente cliente) {
    
        if (cliente.getCpf().equals("111.444.666-45")) {
            return false;
        }

        return true;
    }

}
