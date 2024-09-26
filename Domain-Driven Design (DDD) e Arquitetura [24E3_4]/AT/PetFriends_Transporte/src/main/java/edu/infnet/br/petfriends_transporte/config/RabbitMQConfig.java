package edu.infnet.br.petfriends_transporte.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    private static final String QUEUE_PEDIDO = "pedido-transporte-queue";
    private static final String EXCHANGE_PEDIDO = "pedido-transporte-exc";
    private static final String ROUTING_KEY = "pedido-transporte-rk";

    @Bean
    public Queue pedidosQueue() {
        return new Queue(QUEUE_PEDIDO, true);
    }

    @Bean
    public TopicExchange pedidosExchange() {
        return new TopicExchange(EXCHANGE_PEDIDO);
    }

    @Bean
    public Binding pedidosBinding(Queue pedidosQueue, TopicExchange pedidosExchange) {
        return BindingBuilder.bind(pedidosQueue).to(pedidosExchange).with(ROUTING_KEY);
    }

}
