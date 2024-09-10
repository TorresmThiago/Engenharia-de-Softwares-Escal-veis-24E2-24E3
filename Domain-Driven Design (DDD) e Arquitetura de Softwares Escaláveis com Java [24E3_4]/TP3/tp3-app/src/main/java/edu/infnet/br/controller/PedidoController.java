package edu.infnet.br.controller;

import edu.infnet.br.domain.base.Evento;
import edu.infnet.br.repository.EventoStore;
import edu.infnet.br.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
@Slf4j
public class PedidoController {

    private final PedidoService pedidoService;
    private final EventoStore eventoStore;

    @GetMapping("/")
    public void novoPedido(){
        pedidoService.novoPedido("pedido123", "cliente123", 123);
    }

    @GetMapping("/events")
    public ResponseEntity<List<Evento>> getAllEventos() {
        List<Evento> eventos = eventoStore.getAllEventos();
        return ResponseEntity.ok(eventos);
    }

}
