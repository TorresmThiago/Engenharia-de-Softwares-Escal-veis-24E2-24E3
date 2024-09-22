package edu.infnet.br.questao05.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/questao-05")
@Slf4j
public class Questao05Controller {

    @GetMapping("/status")
    public ResponseEntity status() {
        log.info("Chamada recebida! Status Ok.");
        return ResponseEntity.ok(Map.of("Status", "OK", "Questão", "05"));
    }

}
