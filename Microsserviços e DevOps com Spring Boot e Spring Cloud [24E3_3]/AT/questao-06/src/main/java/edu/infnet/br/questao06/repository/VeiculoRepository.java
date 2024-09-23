package edu.infnet.br.questao06.repository;

import edu.infnet.br.questao06.model.Veiculo;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends R2dbcRepository<Veiculo, Integer> {
}
