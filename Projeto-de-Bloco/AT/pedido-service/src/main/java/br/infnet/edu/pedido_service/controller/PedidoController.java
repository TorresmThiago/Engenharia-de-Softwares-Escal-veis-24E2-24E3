package br.infnet.edu.pedido_service.controller;

import br.infnet.edu.pedido_service.model.Pedido;
import br.infnet.edu.pedido_service.service.NotaFiscalService;
import br.infnet.edu.pedido_service.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@Slf4j
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final NotaFiscalService notaFiscalService;

    @Operation(summary = "Realiza o pedido desejado, mostrando valor total")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "O pedido foi realizado com sucesso"),
            @ApiResponse(responseCode  = "204", description = "Não foi encontrado nenhum tênis válido no pedido"),
            @ApiResponse(responseCode  = "500", description = "O servidor apresentou algum erro ao tentar realizar a ação")
    })
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pedido pedido) {
        try {
            log.info("Pedido: {}", pedido);
            int valorTotal = pedidoService.calcularValorTotal(pedido);

            if (valorTotal <= 0) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhum tênis válido no pedido");
            }

            pedido.setValorTotal(valorTotal);
            Pedido saved = pedidoService.salvar(pedido);
            notaFiscalService.emitirNotaFiscal(pedido);
            return ResponseEntity.status(HttpStatus.OK).body(saved);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
