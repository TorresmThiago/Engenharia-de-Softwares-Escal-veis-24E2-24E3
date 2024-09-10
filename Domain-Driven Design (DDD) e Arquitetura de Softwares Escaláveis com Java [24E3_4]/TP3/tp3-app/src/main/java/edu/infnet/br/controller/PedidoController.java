package edu.infnet.br.controller;

import edu.infnet.br.domain.base.Evento;
import edu.infnet.br.repository.EventoStore;
import edu.infnet.br.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
@Slf4j
public class PedidoController {

    private final PedidoService pedidoService;
    private final EventoStore eventoStore;

    @PostMapping("/")
    public ResponseEntity<String> novoPedido(@RequestParam String pedidoId, @RequestParam String clientId, @RequestParam long valorTotal){
        pedidoService.novoPedido(pedidoId, clientId, valorTotal);
        return ResponseEntity.ok("Pedido criado com sucesso");
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<Evento>> getAllEventos() {
        List<Evento> eventos = eventoStore.getAllEventos();
        return ResponseEntity.ok(eventos);
    }

}
