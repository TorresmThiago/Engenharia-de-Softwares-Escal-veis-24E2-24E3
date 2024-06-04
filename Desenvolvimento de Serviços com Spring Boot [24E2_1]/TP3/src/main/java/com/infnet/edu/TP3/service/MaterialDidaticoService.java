package com.infnet.edu.TP3.service;

import com.infnet.edu.TP3.repository.MaterialDidaticoRepository;
import com.infnet.edu.TP3.model.MaterialDidatico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialDidaticoService {
    @Autowired
    private MaterialDidaticoRepository repository;

    public List<MaterialDidatico> findAll() {
        return repository.findAll();
    }

    public MaterialDidatico findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public MaterialDidatico save(MaterialDidatico material) {
        return repository.save(material);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}