package br.infnet.edu.pedido_service.service;

import br.infnet.edu.pedido_service.model.ItemPedido;
import br.infnet.edu.pedido_service.model.Pedido;
import br.infnet.edu.pedido_service.model.Tenis;
import br.infnet.edu.pedido_service.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final TenisService tenisService;
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    public int calcularValorTotal(Pedido pedido) {
        return pedido.getItens().stream().mapToInt(this::calcularValorItem).sum();
    }
    private int calcularValorItem(ItemPedido itemPedido) {
        Tenis tenis = tenisService.getById(itemPedido.getTenisId());
        return (int) (tenis.getPreco() * itemPedido.getQnt());
    }
}
