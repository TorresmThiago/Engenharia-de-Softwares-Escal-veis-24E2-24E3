package br.infnet.edu.nota_fiscal_service.rabbitmq;

import br.infnet.edu.nota_fiscal_service.model.Pedido;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;
    public void send(Pedido pedido) throws JsonProcessingException {
        amqpTemplate.convertAndSend("nota-fiscal-exc", "nota-fiscal-rk", objectMapper.writeValueAsString(pedido));
    }
}
