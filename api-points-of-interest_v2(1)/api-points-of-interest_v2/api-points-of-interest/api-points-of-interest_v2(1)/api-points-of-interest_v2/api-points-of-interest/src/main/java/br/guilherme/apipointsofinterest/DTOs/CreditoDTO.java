package br.guilherme.apipointsofinterest.DTOs;

import java.lang.reflect.Array;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.guilherme.apipointsofinterest.entities.Credito;
// import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreditoDTO {
    
    @NotBlank
    private long id;

    @NotBlank
    private String tipo;

    @NotBlank
    private Double taxa;

    

    public static CreditoDTO convert(Credito credito) {
        var creditoDTO = new CreditoDTO();
        creditoDTO.setTipo(credito.getTipo());
        creditoDTO.setTaxa(credito.getTaxa());
        creditoDTO.setId(credito.getId());
        
        return creditoDTO;
    }
}
