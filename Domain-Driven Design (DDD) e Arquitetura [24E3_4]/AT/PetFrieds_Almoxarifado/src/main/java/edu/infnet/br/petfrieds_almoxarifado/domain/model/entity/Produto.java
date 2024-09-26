package edu.infnet.br.petfrieds_almoxarifado.domain.model.entity;

import edu.infnet.br.petfrieds_almoxarifado.domain.model.valueobject.CodigoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {
    private CodigoProduto codigoProduto;
    private int quantidade;
}
