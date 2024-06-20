package br.com.infnet.projetoDeBloco.service;

import br.com.infnet.projetoDeBloco.model.Tenis;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParametersException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TenisService {
    void save(Tenis tenis);
    List<Tenis> getAll();
    Optional<Tenis> getById(int id);
    Tenis update(int id, Tenis tenis);
    void delete(int id);
}
