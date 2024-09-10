package br.infnet.edu.pedido_service.service.feign;

import br.infnet.edu.pedido_service.model.Tenis;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("TENIS-SERVICE")
public interface TenisClient {
    @GetMapping("/tenis/{id}")
    Tenis getById(@PathVariable("id") int id);
}
