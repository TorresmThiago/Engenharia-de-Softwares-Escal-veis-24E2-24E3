package edu.infnet.br.questao02;

import edu.infnet.br.questao02.model.Veiculo;
import edu.infnet.br.questao02.service.VeiculoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Questao02ApplicationTests {

    @Autowired
    VeiculoService veiculoService;

    @Test
    void createTest() {
        List<Veiculo> veiculo = veiculoService.getAll();
        int estadoInicial = veiculo.size();

        Veiculo veiculoTeste = new Veiculo(5, "Tesla", "Model 3", 2022);

        veiculoService.save(veiculoTeste);

        veiculo = veiculoService.getAll();
        int estadoFinal = veiculo.size();

        assertEquals(estadoInicial + 1, estadoFinal);
    }

    @Test
    void getAllTest() {
        int listaVeiculoInicial = 4; // Quantidade de veiculo populados pelo arquivo SQL

        List<Veiculo> veiculo = veiculoService.getAll();
        int estadoFinal = veiculo.size();

        assertEquals(estadoFinal, listaVeiculoInicial);
    }

    @Test
    void updateTest() {
        Veiculo veiculo = veiculoService.getById(1).get();
        veiculo.setMarca("Marca Atualizada");

        veiculoService.update(1, veiculo);

        Veiculo veiculoAtualizado = veiculoService.getById(1).get();

        assertEquals(veiculoAtualizado.getMarca(), "Marca Atualizada");
    }

    @Test
    void deleteTest() {
        List<Veiculo> listaVeiculo = veiculoService.getAll();
        int estadoInicial = listaVeiculo.size();

        veiculoService.delete(1);

        listaVeiculo = veiculoService.getAll();
        int estadoFinal = listaVeiculo.size();

        assertEquals(estadoInicial - 1, estadoFinal);
    }

}
