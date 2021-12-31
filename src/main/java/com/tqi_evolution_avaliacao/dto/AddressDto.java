package com.tqi_evolution_avaliacao.dto;

import com.tqi_evolution_avaliacao.entity.Address;
import com.tqi_evolution_avaliacao.entity.Client;

import java.io.Serializable;

public class AddressDto implements Serializable {

    //private Client client;
    private Client client;
    private String rua;
    private int numero;
    private String logadouro;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

    public AddressDto() {
        //padrão
    }

    public AddressDto(Address address) {
        setClient(address.getClient());
        setRua(address.getRua());
        setNumero(address.getNumero());
        setLogadouro(address.getLogadouro());
        setBairro(address.getBairro());
        setCidade(address.getCidade());
        setCep(address.getCep());
        setEstado(address.getEstado());

    }




    public String getClient() {
        //retornando o nome na busca do endereço
        return client.getNome();

    }

    public void setClient(Client client) {
        this.client = client;
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
