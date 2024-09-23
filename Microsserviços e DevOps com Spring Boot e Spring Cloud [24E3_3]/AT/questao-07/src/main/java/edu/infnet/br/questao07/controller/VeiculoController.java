package edu.infnet.br.questao07.controller;

import edu.infnet.br.questao07.model.Veiculo;
import edu.infnet.br.questao07.service.VeiculoWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questao-07/veiculo")
public class VeiculoController {

    private final VeiculoWebClient veiculoClient;

    @GetMapping
    public Flux<Veiculo> findAll() {
        return veiculoClient.findAllVeiculos();
    }

    @GetMapping("/{id}")
    public Mono<Veiculo> findById(@PathVariable int id) {
        return veiculoClient.findVeiculoById(id);
    }

    @PostMapping
    public Mono<Veiculo> save(@RequestBody Veiculo veiculo) {
        return veiculoClient.saveVeiculo(veiculo);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable int id) {
        return veiculoClient.deleteVeiculo(id);
    }

}
