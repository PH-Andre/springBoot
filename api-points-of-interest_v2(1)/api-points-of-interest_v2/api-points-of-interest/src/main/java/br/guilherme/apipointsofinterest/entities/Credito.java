package br.guilherme.apipointsofinterest.entities;

import org.springframework.hateoas.RepresentationModel;

import br.guilherme.apipointsofinterest.DTOs.CreditoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Credito")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Credito extends RepresentationModel<Credito> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "tipo", nullable = false)
    private String Tipo;

    @Column(name = "taxa", nullable = false)
    private double Taxa;

    public static Credito convert(CreditoDTO creditoDTO) {
        var credito = new Credito();
        credito.setId(creditoDTO.getId());
        credito.setTipo(creditoDTO.getTipo());
        credito.setTaxa(creditoDTO.getTaxa());

        return credito;
    }
}


