package br.guilherme.apipointsofinterest.DTOs;

import java.util.List;
import br.guilherme.apipointsofinterest.entities.Credito;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteCreditosDTO {
    
    @NotBlank
    private String nome;
    private List<Credito> creditos;

}
