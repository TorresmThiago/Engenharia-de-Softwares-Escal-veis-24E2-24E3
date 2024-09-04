package br.infnet.edu.pedido_service.service;

import br.infnet.edu.pedido_service.model.Marca;
import br.infnet.edu.pedido_service.service.feign.MarcaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarcaService {
    private final MarcaClient marcaClient;

    public Marca getById(int id){
        return marcaClient.getById(id);
    }
}
