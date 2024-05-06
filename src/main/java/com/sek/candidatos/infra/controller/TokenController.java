package com.sek.candidatos.infra.controller;

import com.sek.candidatos.app.service.JwtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("token")
public class TokenController {
    private final JwtService jwtService;

    public TokenController(JwtService jwtService){
        this.jwtService = jwtService;
    }

    @GetMapping
    public String getToken(){
        return jwtService.generateToken();
    }
}
