package br.infnet.edu.tenis_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TENIS")
public class Tenis {
    @NotBlank
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String modelo;

    @Column(name = "MM_DROP")
    private int drop;
    private int peso;
    private int preco;
    private String entressola;

    @Column(name = "marca_id")
    private int marcaId;
}
