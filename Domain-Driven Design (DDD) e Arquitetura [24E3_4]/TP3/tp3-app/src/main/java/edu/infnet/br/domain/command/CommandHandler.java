package edu.infnet.br.domain.command;

import edu.infnet.br.repository.EventoStore;
import edu.infnet.br.domain.evento.PedidoCriadoEvento;
import edu.infnet.br.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommandHandler {

    private final EventoStore eventoStore;


    public void handlePedido(PedidoCommand command) {
        log.info("Enviando para o servico de pedido");
        PedidoCriadoEvento evento = new PedidoCriadoEvento(command.getPedidoId(), command.getClienteId(), command.getValorTotal());
        eventoStore.save(evento);
    }
}
