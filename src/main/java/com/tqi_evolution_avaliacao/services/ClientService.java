package com.tqi_evolution_avaliacao.services;

import com.tqi_evolution_avaliacao.dto.ClientDto;
import com.tqi_evolution_avaliacao.dto.CreateClientDto;
import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;


    //realizando busca por e-mail
    public ClientDto findByEmail(String email) {
        Optional<Client> client = clientRepository.findByEmail(email);
        //Mapeando o ClientDto
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        return clientDto;
    }
    //realizando busca por cpf
    public ClientDto findByCpf(String cpf) {
        Client client = clientRepository.findByCpf(cpf);
        //Mapeando o ClientDto
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        return clientDto;
    }


    //Salvando um novo cliente
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public ClientDto save(CreateClientDto createClientDto){
        Client client = new Client();
        client.setNome(createClientDto.getNome());
        client.setEmail(createClientDto.getEmail());
        client.setCpf(createClientDto.getCpf());
        client.setRg(createClientDto.getRg());
        client.setRenda(createClientDto.getRenda());
        client.setSenha(createClientDto.getSenha());
        //invocar o repositorio
        //Mapeando o Client para o clientDto
        return modelMapper.map(clientRepository.save(client),ClientDto.class);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void  delete (ClientDto clientDto){
        clientRepository.deleteByCpf(clientDto.getCpf());

    }


}
