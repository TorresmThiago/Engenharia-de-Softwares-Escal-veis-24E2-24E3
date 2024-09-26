package edu.infnet.br.petfriends_transporte.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {
    private int quantidade;
    private String peso;
}
