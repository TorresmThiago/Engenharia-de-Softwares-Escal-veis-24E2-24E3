package edu.infnet.br.petfriends_transporte.domain.service;

import edu.infnet.br.petfriends_transporte.domain.model.entity.EntregaPedido;
import edu.infnet.br.petfriends_transporte.domain.repository.EntregaPedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntregaPedidoService {

    private final EntregaPedidoRepository entregaPedidoRepository;

    public EntregaPedido getEntregaPedido(Long id) {
        return entregaPedidoRepository.findById(id).orElse(null);
    }

    public EntregaPedido atualizarEntregaPedido(EntregaPedido entregaPedido) {
        return entregaPedidoRepository.save(entregaPedido);
    }

}
