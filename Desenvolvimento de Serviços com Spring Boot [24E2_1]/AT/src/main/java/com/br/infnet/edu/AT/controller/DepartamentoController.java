package com.br.infnet.edu.AT.controller;

import com.br.infnet.edu.AT.model.Departamento;
import com.br.infnet.edu.AT.service.DepartamentoService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.MalformedParametersException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/public/departamento")
public class DepartamentoController {
    final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try{
            List<Departamento> departamentosList = departamentoService.getAll();
            if (departamentosList.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhum departamento cadastrado");
            return ResponseEntity.status(HttpStatus.OK).body(departamentosList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        try {
            Optional<Departamento> departamento = departamentoService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(departamento);
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Departamento departamento){
        try {
            departamentoService.create(departamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Departamento %s adicionado!", departamento.getNome()));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Departamento departamento){
        try {
            departamentoService.update(departamento, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Departamento %s atualizado!", departamento.getNome()));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            departamentoService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Departamento %s removido!", id));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

}
