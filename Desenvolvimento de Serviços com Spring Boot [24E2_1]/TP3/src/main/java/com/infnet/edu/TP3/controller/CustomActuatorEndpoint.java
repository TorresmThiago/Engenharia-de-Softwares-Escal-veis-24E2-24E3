package com.infnet.edu.TP3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomActuatorEndpoint {
    @GetMapping("/actuator/custom")
    public Map<String, String> customEndpoint() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "Custom endpoint ativo");
        return response;
    }
}
