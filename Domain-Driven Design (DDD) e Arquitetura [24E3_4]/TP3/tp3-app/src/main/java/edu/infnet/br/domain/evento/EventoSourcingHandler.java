package edu.infnet.br.domain.evento;

import edu.infnet.br.model.Pedido;
import edu.infnet.br.repository.EventoStore;
import edu.infnet.br.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventoSourcingHandler {

    private final PedidoRepository pedidoRepository;

    public void handlePedidoCriadoEvento(PedidoCriadoEvento evento) {
        Pedido pedido = pedidoRepository.findById(evento.getPedidoId())
                .orElseGet(() -> new Pedido(evento.getPedidoId(), evento.getClienteId(), evento.getValorTotal()));

        pedido.criado(evento);

        pedidoRepository.save(pedido);
    }
}
