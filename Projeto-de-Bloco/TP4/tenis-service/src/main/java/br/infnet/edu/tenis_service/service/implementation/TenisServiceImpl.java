package br.infnet.edu.tenis_service.service.implementation;

import br.infnet.edu.tenis_service.model.Tenis;
import br.infnet.edu.tenis_service.repository.TenisRepository;
import br.infnet.edu.tenis_service.service.TenisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParametersException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TenisServiceImpl implements TenisService {

    private final TenisRepository tenisRepository;

    public void save(Tenis tenis) {
        checkTenisParameters(tenis);
        tenisRepository.save(tenis);
    }

    public List<Tenis> getAll(){
        return tenisRepository.findAll();
    }

    public Optional<Tenis> getById(int id){
        return tenisRepository.findById(id);
    }

    public Tenis update(int id, Tenis tenis){
        checkTenisParameters(tenis);
        tenis.setId(id);
        return tenisRepository.save(tenis);
    }

    public void delete(int id){
        tenisRepository.deleteById(id);
    }

    public void checkTenisParameters(Tenis tenis){
        if (tenis.getModelo().isBlank())
            throw new MalformedParametersException("Modelo não pode ser vazio");

        if (tenis.getPeso() <= 0)
            throw new MalformedParametersException("Peso não pode ser nulo ou negativo.");

        if (tenis.getDrop() < 0)
            throw new MalformedParametersException("Drop não pode ser negativo");

        if (tenis.getEntressola().isBlank())
            throw new MalformedParametersException("Entressola não pode ser vazio");
    }

}
