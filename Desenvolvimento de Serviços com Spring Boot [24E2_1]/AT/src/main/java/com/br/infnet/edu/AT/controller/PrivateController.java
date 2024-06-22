package com.br.infnet.edu.AT.controller;

import com.br.infnet.edu.AT.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/private/hello-world")
public class PrivateController {
    @GetMapping
    public String usuarioAutenticado() {
        return "Você foi autenticado com sucesso!";
    }
}
