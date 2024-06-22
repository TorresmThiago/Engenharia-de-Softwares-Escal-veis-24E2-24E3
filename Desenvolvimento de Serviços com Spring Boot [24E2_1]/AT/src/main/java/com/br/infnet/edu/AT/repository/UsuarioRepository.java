package com.br.infnet.edu.AT.repository;

import com.br.infnet.edu.AT.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByNome(String nome);
}
