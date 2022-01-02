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
    private Address address;
    private Loan loan;

    public ClientDto(){
        //padrão
    }




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }


}
