package com.tqi_evolution_avaliacao.controller;

import com.tqi_evolution_avaliacao.dto.ClientDto;
import com.tqi_evolution_avaliacao.dto.CreateClientDto;
import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.repositories.ClientRepository;
import com.tqi_evolution_avaliacao.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientService clientService;

@GetMapping
    public Page<Client> getClients(Pageable page) {
        Page<Client> client = clientRepository.findAll(page);
        return client;
    }

    @GetMapping("search/byEmail")
    public ClientDto getByEmail(@Param("email") String email) {

        return clientService.findByEmail(email);
    }
    @GetMapping("search/byCpf")
    public ClientDto getByCpf(@Param("cpf") String cpf) {

        return clientService.findByCpf(cpf);
    }

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody CreateClientDto createClientDto) {

        ClientDto clientDto = clientService.save(createClientDto);
        if (clientDto == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
        }
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<String> delete(@PathVariable String cpf) {
        ClientDto clientDto = new ClientDto();
        clientDto.setCpf(cpf);
        try {
            clientService.delete(clientDto);
            return new ResponseEntity<>(cpf, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);

        }

    }


}
