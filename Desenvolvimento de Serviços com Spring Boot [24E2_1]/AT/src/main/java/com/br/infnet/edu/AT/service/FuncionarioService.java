package com.br.infnet.edu.AT.service;

import com.br.infnet.edu.AT.repository.FuncionarioRepository;
import com.br.infnet.edu.AT.model.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public void create(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> getAll(){
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario update(Funcionario funcionario, Long id) {
        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
