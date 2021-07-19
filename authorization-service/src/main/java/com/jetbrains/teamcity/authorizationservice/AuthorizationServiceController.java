package com.jetbrains.teamcity.authorizationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationServiceController {

    @GetMapping("/")
    public String hello() {
        return "Welcome To Auth Server";
    }
}
