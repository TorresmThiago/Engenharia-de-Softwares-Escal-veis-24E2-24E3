package br.infnet.edu.marca_service.service.implementation;

import br.infnet.edu.marca_service.model.Marca;
import br.infnet.edu.marca_service.repository.MarcaRepository;
import br.infnet.edu.marca_service.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    @Override
    public void save(Marca marca) {
        marcaRepository.save(marca);
    }

    @Override
    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> getById(int id) {
        return marcaRepository.findById(id);
    }

    @Override
    public Marca update(int id, Marca marca) {
        marca.setId(id);
        return marcaRepository.save(marca);
    }

    @Override
    public void delete(int id) {
        marcaRepository.deleteById(id);
    }
}
