package br.infnet.edu.pedido_service.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Marca {
    private int id;
    private String nome;
    private String pais;
    private String email;
    private LocalDate dataFundacao;
}
