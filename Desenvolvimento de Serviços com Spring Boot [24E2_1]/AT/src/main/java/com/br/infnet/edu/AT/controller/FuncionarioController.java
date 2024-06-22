package com.br.infnet.edu.AT.controller;

import com.br.infnet.edu.AT.model.Funcionario;
import com.br.infnet.edu.AT.service.FuncionarioService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.MalformedParametersException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/public/funcionario")
public class FuncionarioController {
    final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try{
            List<Funcionario> funcionariosList = funcionarioService.getAll();
            if (funcionariosList.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhum funcionário cadastrado");

            return ResponseEntity.status(HttpStatus.OK).body(funcionariosList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        try {
            Optional<Funcionario> funcionario = funcionarioService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(funcionario);
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Funcionario funcionario){
        try {
            funcionarioService.create(funcionario);
            return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Funcionário %s adicionado!", funcionario.getNome()));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Funcionario funcionario){
        try {
            funcionarioService.update(funcionario, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Funcionário %s atualizado!", funcionario.getNome()));
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
            funcionarioService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Funcionário %s removido!", id));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

}
