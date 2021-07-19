package com.jetbrains.teamcity.calculatorservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorServiceController {

    @GetMapping("/")
    public String hello() {
        return "Welcome To Calculation Server";
    }
}
