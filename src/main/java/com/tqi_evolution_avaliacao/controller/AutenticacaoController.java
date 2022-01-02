package com.tqi_evolution_avaliacao.controller;

import com.tqi_evolution_avaliacao.entity.LoginForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Validated LoginForm form) {
        System.out.println(form.getEmail());
        System.out.println(form.getSenha());


        return ResponseEntity.ok().build();

    }
}
