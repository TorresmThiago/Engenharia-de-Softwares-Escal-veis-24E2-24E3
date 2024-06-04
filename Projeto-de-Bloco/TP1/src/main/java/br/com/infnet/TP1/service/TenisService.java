package br.com.infnet.TP1.service;

import br.com.infnet.TP1.model.Tenis;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParametersException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TenisService {

    int uniqueId = 5;

    int getUniqueId()
    {
        return uniqueId++;
    }

    public List<Tenis> tenisList = mockValues();

    private List<Tenis> mockValues(){
        ArrayList<Tenis> temp = new ArrayList<>();
        temp.add(new Tenis(1, "FILA RACER NAIROBI", 8, 290, "EVA"));
        temp.add(new Tenis(2, "ASICS DYNABLAST 4", 8, 260, "FlyteFoam Blast"));
        temp.add(new Tenis(3, "ADIDAS ADIZERO SL", 10, 245, "Lightstrike Pro"));
        temp.add(new Tenis(4, "NIKE PEGASUS 40", 10, 286, "REACT / AIR ZOOM"));
        return temp;
    }

    public void create(Tenis tenis){
        checkTenisParameters(tenis);
        tenis.setId(getUniqueId());
        tenisList.add(tenis);
    }

    public List<Tenis> getAll(){
        return this.tenisList;
    }

    public Tenis getById(int id){
        checkIfTenisExists(id);
        return tenisList.stream().filter(tenis -> tenis.getId() == id).findFirst().get();
    }

    public void update(int id, Tenis tenis){
        checkIfTenisExists(id);
        checkTenisParameters(tenis);
        Tenis temp = getById(id);
        int index = tenisList.indexOf(temp);
        tenisList.set(index, tenis);
    }

    public void delete(int id){
        checkIfTenisExists(id);
        Tenis temp = getById(id);
        tenisList.remove(temp);
    }

    public void checkIfTenisExists(int id) {
        if (id <= 0)
            throw new MalformedParametersException("Parâmetro não pode ser nulo ou negativo");

        if (tenisList.stream().noneMatch(tenis -> tenis.getId() == id))
            throw new OpenApiResourceNotFoundException("Tênis não encontrado");
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
