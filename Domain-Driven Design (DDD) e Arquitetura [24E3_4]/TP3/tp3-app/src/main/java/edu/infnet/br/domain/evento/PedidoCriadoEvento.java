package edu.infnet.br.domain.evento;

import edu.infnet.br.domain.base.Evento;
import lombok.Getter;

@Getter
public class PedidoCriadoEvento extends Evento {

    private final String pedidoId;
    private final String clienteId;
    private final long valorTotal;

    public PedidoCriadoEvento(String pedidoId, String clienteId, long valorTotal) {
        super();
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "PedidoCriadoEvento{" +
                "pedidoId='" + pedidoId + '\'' +
                ", clienteId='" + clienteId + '\'' +
                ", valorTotal=" + valorTotal +
                ", timestamp=" + getTimestamp() +
                '}';
    }
}
