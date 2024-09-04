package br.infnet.edu.pedido_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tenis {
    private int id;
    private String modelo;
    private int drop;
    private int peso;
    private int preco;
    private String entressola;
    private int marcaId;
}
