package com.infnet.TP1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    public double adicaoMethod(double num1, double num2){
        return num1 + num2;
    }

    @GetMapping(value = "/adicao")
    public double adicao(@RequestParam double num1, @RequestParam double num2) {
        return adicaoMethod(num1, num2);
    }
    @PostMapping(value = "/adicao")
    public double adicao(@RequestBody Map<String, Double> requestParams) {
        return adicaoMethod(requestParams.get("num1"), requestParams.get("num2"));
    }

    public double subtracaoMethod(double num1, double num2){
        return num1 - num2;
    }

    @GetMapping(value = "/subtracao")
    public double subtracao(@RequestParam double num1, @RequestParam double num2) {
        return subtracaoMethod(num1, num2);
    }
    @PostMapping(value = "/subtracao")
    public double subtracao(@RequestBody Map<String, Double> requestParams) {
        return subtracaoMethod(requestParams.get("num1"), requestParams.get("num2"));
    }

    public double divisaoMethod(double num1, double num2){
        if (num2 <= 0) {
            return 0;
        }

        return num1 / num2;
    }

    @GetMapping(value = "/divisao")
    public double divisao(@RequestParam double num1, @RequestParam double num2) {
        return divisaoMethod(num1, num2);
    }
    @PostMapping(value = "/divisao")
    public double divisao(@RequestBody Map<String, Double> requestParams) {
        return divisaoMethod(requestParams.get("num1"), requestParams.get("num2"));
    }

    public double multiplicacaoMethod(double num1, double num2){
        return num1 * num2;
    }

    @GetMapping(value = "/multiplicacao")
    public double multiplicacao(@RequestParam double num1, @RequestParam double num2) {
        return multiplicacaoMethod(num1, num2);
    }
    @PostMapping(value = "/multiplicacao")
    public double multiplicacao(@RequestBody Map<String, Double> requestParams) {
        return multiplicacaoMethod(requestParams.get("num1"), requestParams.get("num2"));
    }

    public double exponenciacaoMethod(double num1, double num2){
        return Math.pow(num1, num2);
    }

    @GetMapping(value = "/exponenciacao")
    public double exponenciacao(@RequestParam double num1, @RequestParam double num2) {
        return exponenciacaoMethod(num1, num2);
    }
    @PostMapping(value = "/exponenciacao")
    public double exponenciacao(@RequestBody Map<String, Double> requestParams) {
        return exponenciacaoMethod(requestParams.get("num1"), requestParams.get("num2"));
    }
}
