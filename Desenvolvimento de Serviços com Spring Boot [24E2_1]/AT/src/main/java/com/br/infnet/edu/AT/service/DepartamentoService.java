package com.br.infnet.edu.AT.service;

import com.br.infnet.edu.AT.repository.DepartamentoRepository;
import com.br.infnet.edu.AT.model.Departamento;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public void create(Departamento departamento) {
        departamentoRepository.save(departamento);
    }

    public List<Departamento> getAll(){
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> getById(Long id) {
        return departamentoRepository.findById(id);
    }

    public Departamento update(Departamento departamento, Long id) {
        departamento.setId(id);
        return departamentoRepository.save(departamento);
    }

    public void delete(Long id) {
        departamentoRepository.deleteById(id);
    }

}
