package edu.infnet.br.petfrieds_almoxarifado.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.infnet.br.petfrieds_almoxarifado.domain.events.PedidoCriadoEvent;
import edu.infnet.br.petfrieds_almoxarifado.domain.model.entity.EstoqueProduto;
import edu.infnet.br.petfrieds_almoxarifado.domain.model.entity.Produto;
import edu.infnet.br.petfrieds_almoxarifado.domain.service.EstoqueProdutoService;
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
    private final EstoqueProdutoService estoqueProdutoService;

    @RabbitListener(queues = {"pedido-almoxarifado-queue"})
    public void receberPedido(@Payload String json){
        try {
            PedidoCriadoEvent pedidoCriado = objectMapper.readValue(json, PedidoCriadoEvent.class);
            for (Produto produto : pedidoCriado.getProdutos()) {
                boolean estoqueExiste = estoqueProdutoService.checarEstoque(produto.getCodigoProduto());
                if (estoqueExiste) {
                    EstoqueProduto estoqueProduto = estoqueProdutoService.getEstoqueProdutoByCodigoProduto(produto.getCodigoProduto());
                    estoqueProdutoService.atualizarEstoque(estoqueProduto);
                } else {
                    log.info("Produto não encontrado");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
