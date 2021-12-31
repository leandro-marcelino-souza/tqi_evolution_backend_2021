package com.tqi_evolution_avaliacao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.entity.Loan;

import java.time.LocalDate;

public class CreateLoanDto {
    //private Client client;
    private String email;
    private Double valor;
    private LocalDate dataPrimeiraParcela;
    private int parcelas;
    private LocalDate dataAtual = LocalDate.now();

    public CreateLoanDto(){
        //padrão
    }

    public CreateLoanDto(Loan loan) {
        setValor(loan.getValor());
        setDataPrimeiraParcela(loan.getDataPrimeiraParcela());
        setParcelas(loan.getParcelas());
        setDataAtual(loan.getDataAtual());

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(LocalDate dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }
}
