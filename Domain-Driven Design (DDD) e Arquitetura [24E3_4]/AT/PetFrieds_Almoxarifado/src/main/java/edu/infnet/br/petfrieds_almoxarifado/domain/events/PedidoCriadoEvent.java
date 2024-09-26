package edu.infnet.br.petfrieds_almoxarifado.domain.events;

import edu.infnet.br.petfrieds_almoxarifado.domain.model.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class PedidoCriadoEvent extends DomainEvent{
    private String pedidoId;
    private String clienteId;
    private List<Produto> produtos;
}
