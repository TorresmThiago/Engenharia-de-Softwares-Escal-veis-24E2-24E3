package edu.infnet.br.questao07.service;

import edu.infnet.br.questao07.model.Veiculo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VeiculoWebClient {

    private final WebClient webClient;

    public VeiculoWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9999/questao-06/veiculo").build();
    }

    public Flux<Veiculo> findAllVeiculos() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Veiculo.class);
    }

    public Mono<Veiculo> findVeiculoById(int id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Veiculo.class);
    }

    public Mono<Veiculo> saveVeiculo(Veiculo veiculo) {
        return webClient.post()
                .bodyValue(veiculo)
                .retrieve()
                .bodyToMono(Veiculo.class);
    }

    public Mono<Void> deleteVeiculo(int id) {
        return webClient.delete()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }

}
