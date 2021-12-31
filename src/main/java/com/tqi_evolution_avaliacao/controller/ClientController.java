package com.tqi_evolution_avaliacao.controller;

import com.tqi_evolution_avaliacao.dto.ClientDto;
import com.tqi_evolution_avaliacao.dto.CreateClientDto;
import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    //@Autowired
    //ClientRepository clientRepository;
    @Autowired
    ClientService clientService;


    /*@GetMapping
    public List<ClientDto> findAll(){
        return clientService.clientDtos();
    }*/
    @GetMapping("search/byCpf")
    public ClientDto getByCpf(@Param("cpf") String cpf) {
        return clientService.findByCpf(cpf);
    }

    @PostMapping
    public ResponseEntity<ClientDto> save(@RequestBody  CreateClientDto createClientDto) {

        ClientDto clientDto =  clientService.save(createClientDto);
        if(clientDto==null){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
        }
    }
    @DeleteMapping(value = "/{email}")
    public  ResponseEntity<String> delete (@PathVariable String email){
        ClientDto clientDto = new ClientDto();
        clientDto.setEmail(email);
        try{
            clientService.delete(clientDto);
            return  new ResponseEntity<>(email,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("",HttpStatus.NOT_FOUND);

        }

    }


}
