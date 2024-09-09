package edu.infnet.br.tp3_app.repository;

import edu.infnet.br.tp3_app.model.Fornecedor;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {

    @Query("SELECT * FROM fornecedor WHERE email = :email")
    List<Fornecedor> findByemail(String email);

    @Modifying
    @Query("UPDATE fornecedor SET email = :email WHERE id = :id")
    boolean updateByEmail(@Param("id") Long id, @Param("email") String email);
}
