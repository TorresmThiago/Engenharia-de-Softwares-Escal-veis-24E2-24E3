package edu.infnet.br.petfriends_transporte.domain.events;

import edu.infnet.br.petfriends_transporte.domain.model.entity.Produto;
import edu.infnet.br.petfriends_transporte.domain.model.valueobject.Endereco;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@SuperBuilder
public class PedidoEnviadoEvent extends DomainEvent {
    private Long pedidoId;
    private String nomeCliente;
    private List<Produto> produtos;
    private Endereco enderecoEntrega;
    private LocalDate dataEntregaPrevista;
    private LocalDateTime dataCriacao;
}
