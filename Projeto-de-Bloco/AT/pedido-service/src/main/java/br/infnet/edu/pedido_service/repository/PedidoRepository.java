package br.infnet.edu.pedido_service.repository;

import br.infnet.edu.pedido_service.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
