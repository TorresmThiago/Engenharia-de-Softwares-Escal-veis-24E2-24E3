package br.infnet.edu.tenis_service.repository;

import br.infnet.edu.tenis_service.model.Tenis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenisRepository extends JpaRepository<Tenis, Integer> {
}
