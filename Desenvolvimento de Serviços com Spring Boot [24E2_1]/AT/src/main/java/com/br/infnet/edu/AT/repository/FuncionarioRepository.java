package com.br.infnet.edu.AT.repository;

import com.br.infnet.edu.AT.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
