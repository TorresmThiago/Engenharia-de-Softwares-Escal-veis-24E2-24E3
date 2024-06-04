package com.infnet.edu.TP3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Aluno {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable (
            name = "aluno_curso",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )

    private Set<Curso> cursos = new HashSet<>();
}
