package br.infnet.edu.nota_fiscal_service.controller;

import br.infnet.edu.nota_fiscal_service.model.Pedido;
import br.infnet.edu.nota_fiscal_service.service.NotaFiscalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/nota-fiscal")
@RequiredArgsConstructor
@Slf4j
public class NotaFiscalController {
    private final NotaFiscalService notaFiscalService;
    @PostMapping
    public ResponseEntity<Map<String, String>> gerarNotaFiscal(@RequestBody Pedido pedido) {
        log.info("Gerando nota fiscal do pedido: " + pedido.getId());
        try {
            notaFiscalService.emitirNotaFiscal(pedido);
        } catch (JsonProcessingException e) {
            ResponseEntity.internalServerError().build();
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(Map.of("Message:", "Nota fiscal gerada com sucesso!"));
    }
}
