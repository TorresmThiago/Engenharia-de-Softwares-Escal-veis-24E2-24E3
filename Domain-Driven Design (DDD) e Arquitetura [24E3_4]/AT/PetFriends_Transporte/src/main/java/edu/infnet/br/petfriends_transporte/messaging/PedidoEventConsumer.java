package edu.infnet.br.petfriends_transporte.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.infnet.br.petfrieds_almoxarifado.domain.events.PedidoCriadoEvent;
import edu.infnet.br.petfrieds_almoxarifado.domain.model.entity.EstoqueProduto;
import edu.infnet.br.petfrieds_almoxarifado.domain.model.entity.Produto;
import edu.infnet.br.petfrieds_almoxarifado.domain.service.EstoqueProdutoService;
import edu.infnet.br.petfriends_transporte.domain.events.PedidoEnviadoEvent;
import edu.infnet.br.petfriends_transporte.domain.model.entity.EntregaPedido;
import edu.infnet.br.petfriends_transporte.domain.service.EntregaPedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoEventConsumer {

    private final ObjectMapper objectMapper;
    private final EntregaPedidoService entregaPedidoService;

    @RabbitListener(queues = {"pedido-transporte-queue"})
    public void atualizarPedido(@Payload String json){
        try {
            PedidoEnviadoEvent pedidoCriado = objectMapper.readValue(json, PedidoEnviadoEvent.class);
            EntregaPedido entregaPedido = entregaPedidoService.getEntregaPedido(pedidoCriado.getPedidoId());
            if (entregaPedido != null) {
                entregaPedidoService.atualizarEntregaPedido(entregaPedido);
            } else {
                log.info("Pedido não encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
