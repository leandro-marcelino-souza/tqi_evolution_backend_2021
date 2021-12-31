package com.tqi_evolution_avaliacao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.entity.Loan;

import java.io.Serializable;
import java.time.LocalDate;

public class LoanDto implements Serializable {
    private Long id;
    private Client client;
    private Double valor;
    private LocalDate dataPrimeiraParcela;
    private int parcelas;
    private LocalDate dataAtual = LocalDate.now();

    public LoanDto(){
        //padrão
    }

    public LoanDto(Loan loan) {
        setId(loan.getId());
        setClient(loan.getClient());
        setValor(loan.getValor());
        setDataPrimeiraParcela(loan.getDataPrimeiraParcela());
        setParcelas(loan.getParcelas());
        setDataAtual(loan.getDataAtual());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client.getNome();
    }

    public void setClient(Client client) {
        this.client = client;
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
