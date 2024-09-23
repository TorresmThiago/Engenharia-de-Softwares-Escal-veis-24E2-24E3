package edu.infnet.br.questao06.service;

import edu.infnet.br.questao06.model.Veiculo;
import edu.infnet.br.questao06.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Flux<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Mono<Veiculo> findById(int id) {
        return veiculoRepository.findById(id);
    }

    public Mono<Veiculo> save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Mono<Void> deleteById(int id) {
        return veiculoRepository.deleteById(id);
    }

}
