package com.infnet.TP1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    public double adicaoMethod(double num1, double num2){
        return num1 + num2;
    }

    @RequestMapping(value = "/adicao", method = { RequestMethod.GET, RequestMethod.POST })
    public double adicao(@RequestParam double num1, @RequestParam double num2) {
        return adicaoMethod(num1, num2);
    }

    public double subtracaoMethod(double num1, double num2){
        return num1 - num2;
    }

    @RequestMapping(value = "/subtracao", method = { RequestMethod.GET, RequestMethod.POST })
    public double subtracao(@RequestParam double num1, @RequestParam double num2) {
        return subtracaoMethod(num1, num2);
    }

    public double divisaoMethod(double num1, double num2){
        if (num2 <= 0) {
            return 0;
        }

        return num1 / num2;
    }

    @RequestMapping(value = "/divisao", method = { RequestMethod.GET, RequestMethod.POST })
    public double divisao(@RequestParam double num1, @RequestParam double num2) {
        return divisaoMethod(num1, num2);
    }

    public double multiplicacaoMethod(double num1, double num2){
        return num1 * num2;
    }

    @RequestMapping(value = "/multiplicacao", method = { RequestMethod.GET, RequestMethod.POST })
    public double multiplicacao(@RequestParam double num1, @RequestParam double num2) {
        return multiplicacaoMethod(num1, num2);
    }

    public double exponenciacaoMethod(double num1, double num2){
        return Math.pow(num1, num2);
    }

    @RequestMapping(value = "/exponenciacao", method = { RequestMethod.GET, RequestMethod.POST })
    public double exponenciacao(@RequestParam double num1, @RequestParam double num2) {
        return exponenciacaoMethod(num1, num2);
    }
}
