package edu.infnet.br.domain.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommandGateway {

    private final CommandHandler commandHandler;

    public void send(Object command) {
        if (command instanceof PedidoCommand) {
            commandHandler.handlePedido((PedidoCommand) command);
        } else {
            log.error("Comando não conhecido");
        }
    }
}
