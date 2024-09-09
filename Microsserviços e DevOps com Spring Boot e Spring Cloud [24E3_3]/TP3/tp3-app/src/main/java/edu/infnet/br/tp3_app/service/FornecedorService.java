package edu.infnet.br.tp3_app.service;

import edu.infnet.br.tp3_app.model.Fornecedor;
import edu.infnet.br.tp3_app.repository.FornecedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public void save(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> getAll() {
        return (List<Fornecedor>) fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> getById(long id) {
        return fornecedorRepository.findById(id);
    }

    public Fornecedor update(long id, Fornecedor fornecedor) {
        fornecedor.setId(id);
        return fornecedorRepository.save(fornecedor);
    }

    public void delete(long id) {
        fornecedorRepository.deleteById(id);
    }
    
}
