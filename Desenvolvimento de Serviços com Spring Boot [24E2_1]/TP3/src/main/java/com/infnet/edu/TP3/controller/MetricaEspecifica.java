package com.infnet.edu.TP3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MetricaEspecifica {
    @GetMapping("/actuator/metricaEspecifica")
    public Map<String, String> metricaEspecifica() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "Endpoint ativo");
        return response;
    }
}
