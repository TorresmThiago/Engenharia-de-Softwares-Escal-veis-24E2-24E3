package edu.infnet.br.tp3_app.controller;

import edu.infnet.br.tp3_app.model.Clima;
import edu.infnet.br.tp3_app.service.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ClimaController {
    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping("/clima")
    public Mono<Clima> obterClima(@RequestParam String cidade) {
        return climaService.obterClimaPorCidade(cidade);
    }
}
