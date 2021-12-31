package com.tqi_evolution_avaliacao.controller;

import com.tqi_evolution_avaliacao.dto.AddressDto;
import com.tqi_evolution_avaliacao.dto.ClientDto;
import com.tqi_evolution_avaliacao.dto.CreateAddressDto;
import com.tqi_evolution_avaliacao.entity.Address;
import com.tqi_evolution_avaliacao.repositories.ClientRepository;
import com.tqi_evolution_avaliacao.services.AddressService;
import com.tqi_evolution_avaliacao.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;
    @Autowired
    ClientService clientService;


   @GetMapping("/search/byCep")
    public ResponseEntity<?> getByCep(@Param("cep") String cep){
        return new ResponseEntity<List<AddressDto>>(addressService.findByCep(cep), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateAddressDto > save (@RequestBody CreateAddressDto  caDto ) {
        CreateAddressDto  createAddressDto  =   addressService.save(caDto);

        if(createAddressDto==null) {
            return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<> (createAddressDto, HttpStatus.CREATED);
        }
    }

}
