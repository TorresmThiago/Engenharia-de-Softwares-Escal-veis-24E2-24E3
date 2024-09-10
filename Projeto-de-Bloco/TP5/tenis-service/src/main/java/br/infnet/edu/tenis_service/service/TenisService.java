package br.infnet.edu.tenis_service.service;

import br.infnet.edu.tenis_service.model.Tenis;

import java.util.List;
import java.util.Optional;

public interface TenisService {
    void save(Tenis tenis);
    List<Tenis> getAll();
    Optional<Tenis> getById(int id);
    Tenis update(int id, Tenis tenis);
    void delete(int id);
}
