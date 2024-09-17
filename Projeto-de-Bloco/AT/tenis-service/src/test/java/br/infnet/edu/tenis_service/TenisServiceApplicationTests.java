package br.infnet.edu.tenis_service;

import br.infnet.edu.tenis_service.model.Tenis;
import br.infnet.edu.tenis_service.service.TenisService;
import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TenisServiceApplicationTests {

	@Autowired
	TenisService tenisService;

	@Test
	void createTest() {
		List<Tenis> tenis = tenisService.getAll();
		int estadoInicial = tenis.size();

		Tenis tenisTeste = new Tenis(5, "modelo", 10, 200, 500, "EVA", 1);
		tenisService.save(tenisTeste);

		tenis = tenisService.getAll();
		int estadoFinal = tenis.size();

		assertEquals(estadoInicial + 1, estadoFinal);
	}

	@Test
	void getAllTest() {
		int listaTenisInicial = 4; // Quantidade de tenis populados pelo arquivo SQL

		List<Tenis> tenis = tenisService.getAll();
		int estadoFinal = tenis.size();

		assertEquals(estadoFinal, listaTenisInicial);
	}

	@Test
	void updateTest() {
		Tenis tenis = tenisService.getById(1).get();
		tenis.setModelo("Modelo Atualizado");

		tenisService.update(1, tenis);

		Tenis tenisAtualizado = tenisService.getById(1).get();

		assertEquals(tenisAtualizado.getModelo(), "Modelo Atualizado");
	}

	@Test
	void deleteTest() {
		Tenis tenis = new Tenis(5, "modelo", 10, 200, 500, "EVA", 1);
		tenisService.save(tenis);

		List<Tenis> listaTenis = tenisService.getAll();
		int estadoInicial = listaTenis.size();

		tenisService.delete(5);

		listaTenis = tenisService.getAll();
		int estadoFinal = listaTenis.size();

		assertEquals(estadoInicial - 1, estadoFinal);
	}

}
