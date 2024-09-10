package edu.infnet.br.service;

import edu.infnet.br.domain.command.CommandGateway;
import edu.infnet.br.domain.command.PedidoCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PedidoService {

    private final CommandGateway commandGateway;

    public void novoPedido(String pedidoId, String clienteId, long valorTotal){
        PedidoCommand command = new PedidoCommand(pedidoId, clienteId, valorTotal);
        commandGateway.send(command);
    }
}
