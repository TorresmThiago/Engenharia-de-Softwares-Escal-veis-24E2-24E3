package edu.infnet.br.questao02.service.implementation;

import edu.infnet.br.questao02.model.Veiculo;
import edu.infnet.br.questao02.repository.VeiculoRepository;
import edu.infnet.br.questao02.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Override
    public void save(Veiculo veiculo) {
        veiculoRepository.save(veiculo);
    }

    @Override
    public List<Veiculo> getAll() {
        return veiculoRepository.findAll();
    }

    @Override
    public Optional<Veiculo> getById(int id) {
        return veiculoRepository.findById(id);
    }

    @Override
    public Veiculo update(int id, Veiculo veiculo) {
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }

    @Override
    public void delete(int id) {
        veiculoRepository.deleteById(id);
    }
}
