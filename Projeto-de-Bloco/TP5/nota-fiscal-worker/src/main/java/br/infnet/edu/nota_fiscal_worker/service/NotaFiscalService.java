package br.infnet.edu.nota_fiscal_worker.service;

import br.infnet.edu.nota_fiscal_worker.model.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotaFiscalService {
    public void processar(Pedido pedido){
        log.info("Gerando nota Fiscal do pedido: " + pedido);
    }
}
