package br.infnet.edu.pedido_service.service;

import br.infnet.edu.pedido_service.model.Tenis;
import br.infnet.edu.pedido_service.service.feign.TenisClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenisService {
    private final TenisClient tenisClient;

    public Tenis getById(int id){
        return tenisClient.getById(id);
    }
}
