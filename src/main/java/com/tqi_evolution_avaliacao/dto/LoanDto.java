package com.tqi_evolution_avaliacao.dto;

import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.entity.Loan;

import java.io.Serializable;
import java.time.LocalDate;

public class LoanDto implements Serializable {

    private String nome; // client;
    private String email; // client;
    private Long id;
    private Double valor;
    private LocalDate dataPrimeiraParcela;
    private int parcelas;
    //private LocalDate dataAtual = LocalDate.now();

    public LoanDto() {
        //padrão
    }


    public LoanDto(Loan loan) {
        this.nome = loan.getClient().getNome();
        this.email = loan.getClient().getEmail();
        this.id = loan.getId();
        this.valor = loan.getValor();
        this.dataPrimeiraParcela = loan.getDataPrimeiraParcela();
        this.parcelas = loan.getParcelas();

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDate getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public int getParcelas() {
        return parcelas;
    }
}
