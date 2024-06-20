package br.com.infnet.projetoDeBloco.controller;

import br.com.infnet.projetoDeBloco.model.Marca;
import br.com.infnet.projetoDeBloco.model.Tenis;
import br.com.infnet.projetoDeBloco.service.implementation.MarcaServiceImpl;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.MalformedParametersException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    final MarcaServiceImpl marcaService;

    public MarcaController(MarcaServiceImpl marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try{
            List<Marca> marcaList = marcaService.getAll();
            if (marcaList.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhuma marca cadastrada");

            return ResponseEntity.status(HttpStatus.OK).body(marcaList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        try {
            Optional<Marca> marca = marcaService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(marca);
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Marca marca){
        try {
            marcaService.save(marca);
            return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Marca %s adicionada!", marca.getNome()));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Marca marca){
        try {
            marcaService.update(id, marca);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Marca %s atualizada!", marca.getId()));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            marcaService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Marca %s removida!", id));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
}
