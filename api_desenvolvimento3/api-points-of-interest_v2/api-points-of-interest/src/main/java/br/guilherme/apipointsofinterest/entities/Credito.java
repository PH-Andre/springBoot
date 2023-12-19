package br.guilherme.apipointsofinterest.entities;
import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import br.guilherme.apipointsofinterest.DTOs.CreditoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.var;

@Entity
@Table(name = "Credito")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Credito extends RepresentationModel<Credito> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
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


