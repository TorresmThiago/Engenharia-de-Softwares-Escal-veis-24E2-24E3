package edu.infnet.br.petfrieds_almoxarifado.domain.model.entity;

import edu.infnet.br.petfrieds_almoxarifado.domain.model.valueobject.CodigoProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class EstoqueProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private int quantidade;

    @Embedded
    private CodigoProduto codigoProduto;

}


