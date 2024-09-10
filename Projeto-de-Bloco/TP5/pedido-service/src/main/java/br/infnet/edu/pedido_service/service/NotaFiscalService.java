package br.infnet.edu.pedido_service.service;

import br.infnet.edu.pedido_service.model.Pedido;
import br.infnet.edu.pedido_service.service.feign.NotaFiscalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    private final NotaFiscalClient notaFiscalClient;
    public String emitirNotaFiscal(Pedido pedido) {
        return notaFiscalClient.emitirNotaFiscal(pedido);
    }
}
