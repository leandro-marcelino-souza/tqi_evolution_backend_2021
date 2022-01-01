package com.tqi_evolution_avaliacao.controller;


import com.tqi_evolution_avaliacao.dto.AddressDto;
import com.tqi_evolution_avaliacao.dto.ClientDto;
import com.tqi_evolution_avaliacao.dto.CreateLoanDto;
import com.tqi_evolution_avaliacao.dto.LoanDto;
import com.tqi_evolution_avaliacao.entity.Loan;
import com.tqi_evolution_avaliacao.repositories.LoanRepository;
import com.tqi_evolution_avaliacao.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    LoanService loanService;
    @Autowired
    LoanRepository loanRepository;

  /*  @GetMapping("search/byCpf")
    public ClientDto getByCpf(@Param("cpf") String cpf) {

        return loanService.findByCpf(cpf);
    }*/

    @GetMapping("/{id}") //realizando consulta por Id
    public ResponseEntity<?> getLoan(@PathVariable Long id) {
        return  new ResponseEntity<List<LoanDto>>(loanService.findById(id), HttpStatus.OK);


    }

    @PostMapping
    public ResponseEntity<CreateLoanDto> save(@RequestBody CreateLoanDto clDto) {
        CreateLoanDto createLoanDto = clDto;
        //como a validação via classe está gravando no banco zerado em vez de parar a execução
        //Tive que barra a inserção no banco por aqui(provisorio).
        if (createLoanDto == null || createLoanDto.getParcelas() > 60 || createLoanDto.getParcelas() <=0) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            createLoanDto = loanService.save(clDto);

            return new ResponseEntity<>(createLoanDto, HttpStatus.CREATED);
        }
    }
}
