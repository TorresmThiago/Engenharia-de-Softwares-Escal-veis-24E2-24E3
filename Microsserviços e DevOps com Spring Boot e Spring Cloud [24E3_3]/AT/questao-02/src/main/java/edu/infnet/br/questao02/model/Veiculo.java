package edu.infnet.br.questao02.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "VEICULOS")
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String marca;
    private String modelo;
    private Integer ano;

}