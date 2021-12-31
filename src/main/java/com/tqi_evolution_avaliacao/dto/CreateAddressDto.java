package com.tqi_evolution_avaliacao.dto;

import com.tqi_evolution_avaliacao.entity.Address;
import com.tqi_evolution_avaliacao.entity.Client;

public class CreateAddressDto {

    private String cpf;
    private String rua;
    private int numero;
    private String logadouro;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

    public CreateAddressDto() {

    }
    public CreateAddressDto(Address address) {

        setRua(address.getRua());
        setNumero(address.getNumero());
        setLogadouro(address.getLogadouro());
        setBairro(address.getBairro());
        setCidade(address.getCidade());
        setCep(address.getCep());
        setEstado(address.getEstado());

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
