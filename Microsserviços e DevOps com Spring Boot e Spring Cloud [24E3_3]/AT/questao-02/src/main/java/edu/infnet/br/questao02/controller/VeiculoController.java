package edu.infnet.br.questao02.controller;

import edu.infnet.br.questao02.model.Veiculo;
import edu.infnet.br.questao02.service.implementation.VeiculoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.MalformedParametersException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questao-02/veiculo")
public class VeiculoController {
    final VeiculoServiceImpl veiculoService;

    public VeiculoController(VeiculoServiceImpl veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try{
            List<Veiculo> veiculoList = veiculoService.getAll();
            if (veiculoList.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhuma veiculo cadastrada");

            return ResponseEntity.status(HttpStatus.OK).body(veiculoList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        try {
            Optional<Veiculo> veiculo = veiculoService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(veiculo);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Veiculo veiculo){
        try {
            veiculoService.save(veiculo);
            return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Veiculo %s adicionada!", veiculo.getMarca()));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Veiculo veiculo){
        try {
            veiculoService.update(id, veiculo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Veiculo %s atualizada!", veiculo.getId()));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            veiculoService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Veiculo %s removida!", id));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
}
