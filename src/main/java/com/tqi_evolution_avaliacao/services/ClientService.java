package com.tqi_evolution_avaliacao.services;

import com.tqi_evolution_avaliacao.dto.ClientDto;
import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ClientDto findByEmail(String email) {
        Client client = clientRepository.findByEmail(email);
        //Mapeando o ClientDto
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        return clientDto;
    }


}
