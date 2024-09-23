package edu.infnet.br.questao07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {

    @Bean
    public WebClient.Builder clientBuilder() {
        return WebClient.builder();
    }

}
