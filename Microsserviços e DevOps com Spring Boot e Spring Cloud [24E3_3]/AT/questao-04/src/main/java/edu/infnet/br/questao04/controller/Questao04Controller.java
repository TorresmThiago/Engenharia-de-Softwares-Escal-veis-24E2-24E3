package edu.infnet.br.questao04.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/questao-04")
@Slf4j
public class Questao04Controller {

    @GetMapping("/status")
    public ResponseEntity status() {
        log.info("Chamada recebida! Status Ok.");
        return ResponseEntity.ok(Map.of("Status", "OK"));
    }

}
