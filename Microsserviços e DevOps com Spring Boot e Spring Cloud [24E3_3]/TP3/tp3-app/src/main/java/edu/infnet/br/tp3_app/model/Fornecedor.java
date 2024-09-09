package edu.infnet.br.tp3_app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "fornecedor")
@Data
@AllArgsConstructor@NoArgsConstructor
public class Fornecedor {

    @Id
    private long id;
    private String nome;
    private String tipoProduto;
    private String emailContato;
}
