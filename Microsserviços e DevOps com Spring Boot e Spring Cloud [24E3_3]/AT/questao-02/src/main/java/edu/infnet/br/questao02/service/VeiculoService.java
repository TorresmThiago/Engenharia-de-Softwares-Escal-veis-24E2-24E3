package edu.infnet.br.questao02.service;



import edu.infnet.br.questao02.model.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoService {
    void save (Veiculo veiculo);
    List<Veiculo> getAll();
    Optional<Veiculo> getById(int id);
    Veiculo update(int id, Veiculo veiculo);
    void delete(int id);
}
