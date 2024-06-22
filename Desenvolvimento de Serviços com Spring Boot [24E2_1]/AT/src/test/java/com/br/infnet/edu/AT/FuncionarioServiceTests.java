package com.br.infnet.edu.AT;

import com.br.infnet.edu.AT.model.Departamento;
import com.br.infnet.edu.AT.model.Funcionario;
import com.br.infnet.edu.AT.service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class FuncionarioServiceTests {

    @Autowired
    FuncionarioService funcionarioService;

    @Test
    void createTest() {
        List<Funcionario> funcionarios = funcionarioService.getAll();
        int estadoInicial = funcionarios.size();

        Funcionario funcionario = new Funcionario();
        funcionarioService.create(funcionario);

        funcionarios = funcionarioService.getAll();
        int estadoFinal = funcionarios.size();

        assertEquals(estadoInicial + 1, estadoFinal);
    }

    @Test
    void getAllTest() {
        int listaFuncionariosInicial = 10; // Quantidade de funcionários populados pelo arquivo SQL

        List<Funcionario> funcionarios = funcionarioService.getAll();
        int estadoFinal = funcionarios.size();

        assertEquals(estadoFinal, listaFuncionariosInicial);
    }

    @Test
    void updateTest() {
        Funcionario funcionario = funcionarioService.getById(1L).get();
        funcionario.setNome("Nome Atualizado");

        funcionarioService.update(funcionario, 1L);

        Funcionario funcionarioAtualizado = funcionarioService.getById(1L).get();

        assertEquals(funcionarioAtualizado.getNome(), "Nome Atualizado");
    }

    @Test
    void deleteTest() {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(11L);
        funcionarioService.create(funcionario);

        List<Funcionario> funcionarios = funcionarioService.getAll();
        int estadoInicial = funcionarios.size();

        funcionarioService.delete(11L);

        funcionarios = funcionarioService.getAll();
        int estadoFinal = funcionarios.size();

        assertEquals(estadoInicial - 1, estadoFinal);
    }
}
