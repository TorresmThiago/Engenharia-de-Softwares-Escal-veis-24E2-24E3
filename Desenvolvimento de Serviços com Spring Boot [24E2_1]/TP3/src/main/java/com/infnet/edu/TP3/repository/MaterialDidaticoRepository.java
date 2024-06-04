package com.infnet.edu.TP3.repository;

import com.infnet.edu.TP3.model.MaterialDidatico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, String> {
}
