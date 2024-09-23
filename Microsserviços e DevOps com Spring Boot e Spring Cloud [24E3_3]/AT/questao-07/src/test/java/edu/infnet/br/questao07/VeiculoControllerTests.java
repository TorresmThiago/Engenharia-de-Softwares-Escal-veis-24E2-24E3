package edu.infnet.br.questao07;

import edu.infnet.br.questao07.controller.VeiculoController;
import edu.infnet.br.questao07.model.Veiculo;
import edu.infnet.br.questao07.service.VeiculoWebClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@WebFluxTest(VeiculoController.class)
public class VeiculoControllerTests {

    @Autowired
    private WebTestClient client;

    @MockBean
    private VeiculoWebClient veiculoWebClient;

    private Veiculo veiculo;

    @BeforeEach
    void setUp() {
        veiculo = new Veiculo(1, "Volkswagen", "Fox", 2009);
    }

    @Test
    public void testFindAll() {
        doReturn(Flux.just(veiculo)).when(veiculoWebClient).findAllVeiculos();

        client.get().uri("/questao-07/veiculo")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Veiculo.class)
                .hasSize(1)
                .contains(veiculo);

        verify(veiculoWebClient, times(1)).findAllVeiculos();
    }

    @Test
    public void testFindById() {
        doReturn(Mono.just(veiculo)).when(veiculoWebClient).findVeiculoById(1);
        client.get().uri("/questao-07/veiculo/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Veiculo.class)
                .isEqualTo(veiculo);

        verify(veiculoWebClient, times(1)).findVeiculoById(1);
    }

    @Test
    public void testCreate() {
        Veiculo novoVeiculo = new Veiculo(null, "Volkswagen", "Crossfox", 2012);
        Veiculo veiculoSalvo = new Veiculo(2, "Volkswagen", "Crossfox", 2012);

        doReturn(Mono.just(veiculoSalvo)).when(veiculoWebClient).saveVeiculo(novoVeiculo);

        client.post().uri("/questao-07/veiculo")
                .bodyValue(novoVeiculo)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Veiculo.class)
                .isEqualTo(veiculoSalvo);

        verify(veiculoWebClient, times(1)).saveVeiculo(novoVeiculo);
    }

    @Test
    public void testDelete() {
        doReturn(Mono.empty()).when(veiculoWebClient).deleteVeiculo(1);
        client.delete().uri("/questao-07/veiculo/1")
                .exchange()
                .expectStatus().isOk();

        verify(veiculoWebClient, times(1)).deleteVeiculo(1);
    }

}
