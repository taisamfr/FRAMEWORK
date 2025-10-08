package com.devsenai1A.conversor.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorControllers {

    @PostMapping("/converter")
    public Map<String, Object> converter(
            @RequestParam double valor,
            @RequestParam String de,
            @RequestParam String para
            ){

        Map<String, Object> resposta = new HashMap<>();

        if (de.equals(para)) {
            resposta.put("resultado", valor);
            resposta.put("unidade", unidadeSimbolo(para));
            return resposta;
        }

           double resultado = 0;


            switch(de) {
                case "BRL": 
                if(para.equals("USD")) resultado = valor/5.35;
                if(para.equals("EUR")) resultado = valor/6.23;
                    break;
                case "USD": 
                if(para.equals("BRL")) resultado = valor*5.35;
                if(para.equals("EUR")) resultado = valor/0.86;
                    break;
                case "EUR": 
                if(para.equals("BRL")) resultado = valor*6.23;
                if(para.equals("USD")) resultado = valor/1.17;
                    break;
            }


                resposta.put("resultado", String.format("%.2f", resultado));
                resposta.put("unidade", unidadeSimbolo(para));


            return resposta;
    }

            private String unidadeSimbolo(String unidade) {
                return switch (unidade.toLowerCase()) {
                    case "BRL" -> "R$";
                    case "USD" -> "US$";
                    case "EUR" -> "€";
                    default -> "";

                };

        }
}