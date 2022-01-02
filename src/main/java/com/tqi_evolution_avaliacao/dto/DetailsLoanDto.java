package com.tqi_evolution_avaliacao.dto;

import com.tqi_evolution_avaliacao.entity.Loan;

import java.time.LocalDate;

public class DetailsLoanDto {

    private Long id;
    private Double valor;
    private int parcelas;
    private LocalDate dataPrimeiraParcela;
    private String email;
    private Double renda;

    public DetailsLoanDto(Loan loan) {
        this.id = loan.getId();
        this.valor = loan.getValor();
        this.parcelas = loan.getParcelas();
        this.dataPrimeiraParcela = loan.getDataPrimeiraParcela();
        this.email = loan.getClient().getEmail();
        this.renda = loan.getClient().getRenda();
    }

    public Long getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public LocalDate getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public String getEmail() {
        return email;
    }

    public Double getRenda() {
        return renda;
    }
}
