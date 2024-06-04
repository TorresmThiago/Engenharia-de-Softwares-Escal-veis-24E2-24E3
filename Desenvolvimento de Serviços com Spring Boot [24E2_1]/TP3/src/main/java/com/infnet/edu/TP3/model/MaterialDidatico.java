package com.infnet.edu.TP3.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collation = "materialDidatico")
public class MaterialDidatico {
    @Id
    private String id;
    private String titulo;
    private String conteudo;
}
