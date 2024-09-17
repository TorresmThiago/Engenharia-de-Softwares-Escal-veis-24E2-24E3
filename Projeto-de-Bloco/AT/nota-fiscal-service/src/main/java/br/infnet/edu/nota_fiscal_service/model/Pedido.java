package br.infnet.edu.nota_fiscal_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {
    private String id;
    private List<ItemPedido> itens;
    private int valorTotal;
}
