package br.guilherme.apipointsofinterest.DTOs;

import br.guilherme.apipointsofinterest.entities.Cliente;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDTO {
    @Min(1)
    @NotBlank
    private int age;

    @NotBlank
    private String cpf;

    @NotBlank
    private String name;

    @Min(1)
    @NotBlank
    private double income;

    @NotBlank
    private double location;


    public static ClienteDTO convert(Cliente cliente) {
        var clienteDTO = new ClienteDTO();
        clienteDTO.setAge(cliente.getAge());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setName(cliente.getName());
        clienteDTO.setIncome(cliente.getIncome());
        clienteDTO.setLocation(cliente.getLocation());
        return clienteDTO;
    }
}
