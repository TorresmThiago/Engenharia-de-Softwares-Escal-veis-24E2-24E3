package br.infnet.edu.pedido_service.controller;

import br.infnet.edu.pedido_service.model.Pedido;
import br.infnet.edu.pedido_service.service.NotaFiscalService;
import br.infnet.edu.pedido_service.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
@Slf4j
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final NotaFiscalService notaFiscalService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pedido pedido) {
        log.info("Pedido: {}", pedido);
        int valorTotal = pedidoService.calcularValorTotal(pedido);
        pedido.setValorTotal(valorTotal);
        Pedido saved = pedidoService.salvar(pedido);
        notaFiscalService.emitirNotaFiscal(pedido);
        return ResponseEntity.ok(saved);
    }
}
