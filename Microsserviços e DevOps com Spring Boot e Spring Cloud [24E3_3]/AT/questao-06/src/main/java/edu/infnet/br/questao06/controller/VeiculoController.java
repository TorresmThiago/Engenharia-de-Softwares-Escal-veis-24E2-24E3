package edu.infnet.br.questao06.controller;

import edu.infnet.br.questao06.model.Veiculo;
import edu.infnet.br.questao06.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/questao-06/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public Flux<Veiculo> getAll() {
        return veiculoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Veiculo> get(@PathVariable int id){
        return veiculoService.findById(id);
    }

    @PostMapping
    public Mono<Veiculo> create(@RequestBody Veiculo veiculo){
        return veiculoService.save(veiculo);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> delete(@PathVariable int id){
        return veiculoService.deleteById(id);
    }
}
