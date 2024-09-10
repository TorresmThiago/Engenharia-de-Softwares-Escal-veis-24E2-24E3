package br.infnet.edu.marca_service.service;


import br.infnet.edu.marca_service.model.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    void save (Marca marca);
    List<Marca> getAll();
    Optional<Marca> getById(int id);
    Marca update(int id, Marca marca);
    void delete(int id);
}
