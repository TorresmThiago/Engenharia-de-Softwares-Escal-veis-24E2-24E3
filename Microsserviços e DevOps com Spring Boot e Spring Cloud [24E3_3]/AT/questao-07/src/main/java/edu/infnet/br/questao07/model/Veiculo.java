package edu.infnet.br.questao07.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "VEICULOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    @Id
    private Integer id;

    private String marca;
    private String modelo;
    private Integer ano;

}