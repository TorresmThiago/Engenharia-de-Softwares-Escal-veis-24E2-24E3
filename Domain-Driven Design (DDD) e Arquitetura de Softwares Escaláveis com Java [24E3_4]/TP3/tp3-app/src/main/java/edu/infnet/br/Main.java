package edu.infnet.br;

import edu.infnet.br.repository.EventoStore;
import edu.infnet.br.domain.command.CommandGateway;
import edu.infnet.br.domain.command.CommandHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    EventoStore eventoStore = new EventoStore();
    CommandHandler commandHandler = new CommandHandler(eventoStore);
    CommandGateway commandGateway = new CommandGateway(commandHandler);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}