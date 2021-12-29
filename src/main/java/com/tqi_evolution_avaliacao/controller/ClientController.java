package com.tqi_evolution_avaliacao.controller;

import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @RequestMapping("/clients")
    public List<Client> getClients(){
        return clientRepository.findAll();
    }
}
