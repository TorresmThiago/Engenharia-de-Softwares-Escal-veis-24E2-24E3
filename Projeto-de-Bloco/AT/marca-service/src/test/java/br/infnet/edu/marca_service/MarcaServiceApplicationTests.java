package br.infnet.edu.marca_service;

import br.infnet.edu.marca_service.model.Marca;
import br.infnet.edu.marca_service.service.MarcaService;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MarcaServiceApplicationTests {

	@Autowired
	MarcaService marcaService;

	@Test
	void createTest() {
		List<Marca> marca = marcaService.getAll();
		int estadoInicial = marca.size();

		Marca marcaTeste = new Marca(5, "marca", "pais", "contato@email.com", LocalDate.now());

		marcaService.save(marcaTeste);

		marca = marcaService.getAll();
		int estadoFinal = marca.size();

		assertEquals(estadoInicial + 1, estadoFinal);
	}

	@Test
	void getAllTest() {
		int listaMarcaInicial = 4; // Quantidade de marca populados pelo arquivo SQL

		List<Marca> marca = marcaService.getAll();
		int estadoFinal = marca.size();

		assertEquals(estadoFinal, listaMarcaInicial);
	}

	@Test
	void updateTest() {
		Marca marca = marcaService.getById(1).get();
		marca.setNome("Nome Atualizado");

		marcaService.update(1, marca);

		Marca marcaAtualizado = marcaService.getById(1).get();

		assertEquals(marcaAtualizado.getNome(), "Nome Atualizado");
	}

	@Test
	void deleteTest() {
		Marca marca = new Marca(5, "marca", "pais", "contato@email.com", LocalDate.now());
		marcaService.save(marca);

		List<Marca> listaMarca = marcaService.getAll();
		int estadoInicial = listaMarca.size();

		marcaService.delete(5);

		listaMarca = marcaService.getAll();
		int estadoFinal = listaMarca.size();

		assertEquals(estadoInicial - 1, estadoFinal);
	}
}
