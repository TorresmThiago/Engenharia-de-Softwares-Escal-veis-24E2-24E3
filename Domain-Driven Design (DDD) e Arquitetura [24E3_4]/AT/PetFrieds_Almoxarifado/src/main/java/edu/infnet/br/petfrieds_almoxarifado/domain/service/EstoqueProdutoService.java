package edu.infnet.br.petfrieds_almoxarifado.domain.service;

import edu.infnet.br.petfrieds_almoxarifado.domain.model.entity.EstoqueProduto;
import edu.infnet.br.petfrieds_almoxarifado.domain.model.valueobject.CodigoProduto;
import edu.infnet.br.petfrieds_almoxarifado.domain.repository.EstoqueProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstoqueProdutoService {

    private final EstoqueProdutoRepository estoqueProdutoRepository;

    public EstoqueProduto getEstoqueProdutoByCodigoProduto(CodigoProduto codigo) {
        return estoqueProdutoRepository.findByCodigoProduto(codigo);
    }

    public boolean checarEstoque(CodigoProduto codigoProduto) {
        EstoqueProduto estoqueProduto = estoqueProdutoRepository.findByCodigoProduto(codigoProduto);
        return estoqueProduto != null;
    }

    public void atualizarEstoque(EstoqueProduto estoqueProduto) {
        estoqueProdutoRepository.save(estoqueProduto);
    }

}
