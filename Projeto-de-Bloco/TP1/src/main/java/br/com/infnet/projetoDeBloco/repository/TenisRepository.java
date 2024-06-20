package br.com.infnet.projetoDeBloco.repository;

import br.com.infnet.projetoDeBloco.model.Tenis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenisRepository extends JpaRepository<Tenis, Integer> {
}
