package br.guilherme.apipointsofinterest.entities;

import org.springframework.hateoas.RepresentationModel;

import br.guilherme.apipointsofinterest.DTOs.ClienteDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Cliente extends RepresentationModel<Cliente> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "income", nullable = false)
    private double income;

    @Column(name = "location", nullable = false)
    private double location;

    public static Cliente convert(ClienteDTO clienteDTO) {
        var cliente = new Cliente();
        cliente.setAge(clienteDTO.getAge());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setName(clienteDTO.getName());
        cliente.setIncome(clienteDTO.getIncome());
        cliente.setLocation(clienteDTO.getLocation());

        return cliente;
    }
}


