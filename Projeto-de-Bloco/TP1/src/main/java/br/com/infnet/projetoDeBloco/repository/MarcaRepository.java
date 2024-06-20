package br.com.infnet.projetoDeBloco.repository;

import br.com.infnet.projetoDeBloco.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
