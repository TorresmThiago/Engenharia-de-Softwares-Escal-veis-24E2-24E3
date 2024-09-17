package br.infnet.edu.nota_fiscal_service.service;

import br.infnet.edu.nota_fiscal_service.model.Pedido;
import br.infnet.edu.nota_fiscal_service.rabbitmq.NotaFiscalProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    private final NotaFiscalProducer notaFiscalProducer;
    public void emitirNotaFiscal(Pedido pedido) throws JsonProcessingException{
        notaFiscalProducer.send(pedido);
    }
}
