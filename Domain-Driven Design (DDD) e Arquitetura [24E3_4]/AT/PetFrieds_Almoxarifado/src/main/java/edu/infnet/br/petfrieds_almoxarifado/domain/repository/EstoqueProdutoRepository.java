package edu.infnet.br.petfrieds_almoxarifado.domain.repository;

import edu.infnet.br.petfrieds_almoxarifado.domain.model.entity.EstoqueProduto;
import edu.infnet.br.petfrieds_almoxarifado.domain.model.valueobject.CodigoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProduto, Long> {

    EstoqueProduto findByCodigoProduto(CodigoProduto codigoProduto);

}
