package edu.infnet.br.questao06.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "VEICULOS")
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Veiculo {

    @Id
    private int id;

    private String marca;
    private String modelo;
    private Integer ano;

}