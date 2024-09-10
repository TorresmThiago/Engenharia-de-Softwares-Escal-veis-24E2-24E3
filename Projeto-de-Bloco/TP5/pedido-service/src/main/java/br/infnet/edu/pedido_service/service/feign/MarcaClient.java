package br.infnet.edu.pedido_service.service.feign;

import br.infnet.edu.pedido_service.model.Marca;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("MARCA-SERVICE")
public interface MarcaClient {
    @GetMapping("/marca/{id}")
    Marca getById(@PathVariable("id") int id);
}
