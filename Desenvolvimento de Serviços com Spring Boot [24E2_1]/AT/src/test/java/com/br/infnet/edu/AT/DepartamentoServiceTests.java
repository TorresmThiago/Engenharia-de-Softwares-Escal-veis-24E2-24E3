package com.br.infnet.edu.AT;

import com.br.infnet.edu.AT.model.Departamento;
import com.br.infnet.edu.AT.model.Departamento;
import com.br.infnet.edu.AT.service.DepartamentoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
public class DepartamentoServiceTests {

    @Autowired
    DepartamentoService departamentoService;

    @Test
    void createTest() {
        List<Departamento> departamentos = departamentoService.getAll();
        int estadoInicial = departamentos.size();

        Departamento departamento = new Departamento();
        departamentoService.create(departamento);

        departamentos = departamentoService.getAll();
        int estadoFinal = departamentos.size();

        assertEquals(estadoInicial + 1, estadoFinal);
    }

    @Test
    void getAllTest() {
        int listaDepartamentosInicial = 5; // Quantidade de funcionários populados pelo arquivo SQL

        List<Departamento> departamentos = departamentoService.getAll();
        int estadoFinal = departamentos.size();

        assertEquals(estadoFinal, listaDepartamentosInicial);
    }

    @Test
    void updateTest() {
        Departamento departamento = departamentoService.getById(1L).get();
        departamento.setNome("Nome Atualizado");

        departamentoService.update(departamento, 1L);

        Departamento departamentoAtualizado = departamentoService.getById(1L).get();

        assertEquals(departamentoAtualizado.getNome(), "Nome Atualizado");
    }

    @Test
    void deleteTest() {
        Departamento departamento = new Departamento();
        departamento.setId(6L);
        departamentoService.create(departamento);

        List<Departamento> departamentos = departamentoService.getAll();
        int estadoInicial = departamentos.size();

        departamentoService.delete(6L);

        departamentos = departamentoService.getAll();
        int estadoFinal = departamentos.size();

        assertEquals(estadoInicial - 1, estadoFinal);
    }
}
