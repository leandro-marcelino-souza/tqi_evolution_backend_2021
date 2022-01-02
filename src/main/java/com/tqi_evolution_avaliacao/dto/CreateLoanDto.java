package com.tqi_evolution_avaliacao.dto;


import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.entity.Loan;

import java.time.LocalDate;

import java.time.Duration;


public class CreateLoanDto {
    //private Client client;
    private String cpf;
    private Double valor;
    private LocalDate dataPrimeiraParcela;
    private int parcelas;
    private LocalDate dataAtual = LocalDate.now();

    public CreateLoanDto() {
        //padrão
    }

    public CreateLoanDto(Loan loan) {

        setValor(loan.getValor());
        setDataPrimeiraParcela(loan.getDataPrimeiraParcela());
        setParcelas(loan.getParcelas());
        setDataAtual(loan.getDataAtual());

    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

        //subtrair duas datas em Java
        Duration diff = Duration.between(dataAtual.atStartOfDay(), dataPrimeiraParcela.atStartOfDay());
        long diffDays = diff.toDays();
        if (diffDays <= 90) {
            this.dataPrimeiraParcela = dataPrimeiraParcela;
        } else {
            return;
        }


    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {

        if (parcelas > 1 && parcelas < 61) {
            this.parcelas = parcelas;
            System.out.println("emprestimo entre 1 e 60 parcelas");
        } else {
            System.out.println("Parcelas não pode ser zeradas ou maior que 60");
            return;
        }
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }
}
