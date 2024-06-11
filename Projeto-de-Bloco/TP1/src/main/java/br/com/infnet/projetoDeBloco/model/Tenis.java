package br.com.infnet.projetoDeBloco.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tenis {
    private int id;
    private String modelo;
    private int drop;
    private int peso;
    private String entressola;
}
