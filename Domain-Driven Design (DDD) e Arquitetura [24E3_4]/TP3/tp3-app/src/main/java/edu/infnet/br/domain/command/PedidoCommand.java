package edu.infnet.br.domain.command;

import edu.infnet.br.domain.base.Command;
import lombok.Getter;

@Getter
public class PedidoCommand extends Command {

    private final String pedidoId;
    private final String clienteId;
    private final long valorTotal;

    public PedidoCommand(String pedidoId, String clienteId, long valorTotal) {
        super();
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "CriarPedidoCommand{" +
                "pedidoId='" + pedidoId + '\'' +
                ", clienteId='" + clienteId + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
