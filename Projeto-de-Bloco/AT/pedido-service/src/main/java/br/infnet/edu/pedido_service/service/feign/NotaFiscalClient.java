package br.infnet.edu.pedido_service.service.feign;

import br.infnet.edu.pedido_service.model.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("NOTA-FISCAL-SERVICE")
public interface NotaFiscalClient {
    @PostMapping("/nota-fiscal")
    String emitirNotaFiscal(@RequestBody Pedido pedido);
}
