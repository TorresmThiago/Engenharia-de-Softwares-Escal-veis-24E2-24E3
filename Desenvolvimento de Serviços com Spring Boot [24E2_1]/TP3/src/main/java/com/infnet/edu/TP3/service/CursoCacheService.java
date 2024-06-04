package com.infnet.edu.TP3.service;

import com.infnet.edu.TP3.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CursoCacheService {

    private static final String HASH_KEY = "Curso";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void save(Curso curso) {
        redisTemplate.opsForHash().put(HASH_KEY, curso.getId().toString(), curso);
    }

    public Curso findById(Long id) {
        return (Curso) redisTemplate.opsForHash().get(HASH_KEY, id.toString());
    }
}
