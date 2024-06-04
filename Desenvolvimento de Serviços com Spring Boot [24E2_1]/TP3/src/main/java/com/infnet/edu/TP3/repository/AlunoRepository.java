package com.infnet.edu.TP3.repository;

import com.infnet.edu.TP3.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
