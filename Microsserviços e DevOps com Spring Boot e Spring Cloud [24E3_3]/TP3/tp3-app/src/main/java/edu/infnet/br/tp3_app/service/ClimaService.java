package edu.infnet.br.tp3_app.service;

import edu.infnet.br.tp3_app.model.Clima;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ClimaService {
    private final WebClient webClient;

    public ClimaService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Clima> obterClimaPorCidade(String cidade) {
        String apiKey = "bca951d05679e93b77013819709ce3f5";
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", cidade)
                        .queryParam("units", "metric")
                        .queryParam("appid", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(Clima.class);
    }
}
