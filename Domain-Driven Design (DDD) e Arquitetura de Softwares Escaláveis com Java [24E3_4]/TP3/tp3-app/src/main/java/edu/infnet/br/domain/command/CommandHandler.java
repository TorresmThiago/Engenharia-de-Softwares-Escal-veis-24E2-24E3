package edu.infnet.br.domain.command;

import edu.infnet.br.domain.base.Command;
import edu.infnet.br.domain.base.Evento;
import edu.infnet.br.domain.base.EventoStore;
import edu.infnet.br.domain.evento.PedidoCriadoEvento;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandHandler {

    private final EventoStore eventoStore;

    public void handleCriarPedido(CriarPedidoCommand command) {
        System.out.println("Enviando para o servico de pedido");
        PedidoCriadoEvento evento = new PedidoCriadoEvento(command.getPedidoId(), command.getClienteId(), command.getValorTotal());
        eventoStore.save(evento);
    }
}
