package edu.infnet.br.petfriends_transporte.domain.model.entity;

import edu.infnet.br.petfriends_transporte.domain.model.valueobject.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor
public class EntregaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private String status;

    @Embedded
    @Column(nullable = false)
    private Endereco enderecoEnvio;

    private LocalDateTime dataEnvio;

    private LocalDateTime dataRecebimento;
}
