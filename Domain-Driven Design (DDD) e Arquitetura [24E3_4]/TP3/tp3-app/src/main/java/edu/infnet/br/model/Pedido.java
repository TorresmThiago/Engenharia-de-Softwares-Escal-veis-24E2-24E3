package edu.infnet.br.model;

import edu.infnet.br.domain.evento.PedidoCriadoEvento;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "PEDIDO")
@Data
@AllArgsConstructor@NoArgsConstructor@Builder
public class Pedido {

    @Id
    private String pedidoId;
    private String clienteId;
    private long valorTotal;

    public void criado(PedidoCriadoEvento evento) {
        this.pedidoId = evento.getPedidoId();
        this.clienteId = evento.getClienteId();
        this.valorTotal = evento.getValorTotal();
    }

}
