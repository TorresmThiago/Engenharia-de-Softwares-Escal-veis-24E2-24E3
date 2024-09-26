package edu.infnet.br.petfriends_transporte.domain.repository;

import edu.infnet.br.petfriends_transporte.domain.model.entity.EntregaPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntregaPedidoRepository extends JpaRepository<EntregaPedido, Long> {

    List<EntregaPedido> findByPedidoId(Long pedidoId);

    List<EntregaPedido> findByStatus(String status);

}



