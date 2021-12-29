package com.tqi_evolution_avaliacao.dto;

import com.tqi_evolution_avaliacao.entity.Address;
import com.tqi_evolution_avaliacao.entity.Loan;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class ClientDto {

    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private Double renda;
    private List<Address> addressList = new ArrayList<Address>();
    private List<Loan> loanList = new ArrayList<Loan>();
}
