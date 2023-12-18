package br.guilherme.apipointsofinterest.DTOs;

import br.guilherme.apipointsofinterest.entities.Cliente;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDTO {
    
    @Min(value = 1, message = "A idade deve ser maior que 0")
    private int age;

    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos")
    private String cpf;

    @NotEmpty(message = "O nome não pode ser vazio")
    private String name;

   
    @Min(value = 3000, message = "A renda deve ser maior que 2999")
    private double income;

    @NotEmpty(message = "A localização não pode ser vazia")
    private String location;


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
