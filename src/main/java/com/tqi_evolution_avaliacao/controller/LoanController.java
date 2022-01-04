package com.tqi_evolution_avaliacao.controller;


import com.tqi_evolution_avaliacao.dto.*;
import com.tqi_evolution_avaliacao.entity.Address;
import com.tqi_evolution_avaliacao.entity.Loan;
import com.tqi_evolution_avaliacao.repositories.LoanRepository;
import com.tqi_evolution_avaliacao.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    LoanService loanService;
    @Autowired
    LoanRepository loanRepository;


    @PostMapping
    public ResponseEntity<CreateLoanDto> save(@RequestBody CreateLoanDto clDto) {
        CreateLoanDto createLoanDto = clDto;
        //como a validação via classe está gravando no banco zerado em vez de parar a execução
        //Tive que barra a inserção no banco por aqui.
        if (createLoanDto == null || createLoanDto.getParcelas() > 60 || createLoanDto.getParcelas() <=0) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            createLoanDto = loanService.save(clDto);

            return new ResponseEntity<>(createLoanDto, HttpStatus.CREATED);
        }
    }


    @GetMapping("/search/byCpf")
    public ResponseEntity<?> getByCpf(@Param("cpf") String cpf){
        return new ResponseEntity<List<LoanDto>>(loanService.findByClientCpf(cpf), HttpStatus.OK);
    }

    //realizando consulta por Id/detalhesDoEmprestimo
    @GetMapping("/{id}")
    public DetailsLoanDto detalhar(@PathVariable Long id) {
        Loan loan = loanRepository.getOne(id);

        return new DetailsLoanDto(loan);


    }

/*

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Loan loan = new Loan();
        loan.setId(id);
        try {
            loanRepository.delete(loan);
            return new ResponseEntity(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);

        }

    }
*/


}
