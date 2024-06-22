package com.br.infnet.edu.AT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "USUARIOS")
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String senha;
    private String papel;
}
