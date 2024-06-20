package br.com.infnet.projetoDeBloco.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String entressola;

    @ManyToOne
    private Marca marca;
}
