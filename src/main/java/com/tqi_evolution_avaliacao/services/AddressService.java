package com.tqi_evolution_avaliacao.services;

import com.tqi_evolution_avaliacao.dto.AddressDto;
import com.tqi_evolution_avaliacao.dto.CreateAddressDto;
import com.tqi_evolution_avaliacao.entity.Address;
import com.tqi_evolution_avaliacao.repositories.AddressRepository;
import com.tqi_evolution_avaliacao.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AddressService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<AddressDto> findByCep(String cep) {
        List<Address> address =  addressRepository.findByCep(cep);

        return address.stream().map(x -> new AddressDto(x)).collect(Collectors.toList());
    }

    @Transactional(propagation= Propagation.REQUIRED, readOnly=false)
    public CreateAddressDto save(CreateAddressDto createAddressDto) {
        Address address = new Address();
        address.setRua(createAddressDto.getRua());
        address.setNumero(createAddressDto.getNumero());
        address.setLogadouro(createAddressDto.getLogadouro());
        address.setBairro(createAddressDto.getBairro());
        address.setCidade(createAddressDto.getCidade());
        address.setCep(createAddressDto.getCep());
        address.setEstado(createAddressDto.getEstado());
        address.setClient(clientRepository.findByEmail(createAddressDto.getEmail()));

        address = addressRepository.save(address);

        CreateAddressDto retorno = new CreateAddressDto();
        retorno.setRua(address.getRua());
        retorno.setNumero(address.getNumero());
        retorno.setLogadouro(address.getLogadouro());
        retorno.setBairro(address.getBairro());
        retorno.setCidade(address.getCidade());
        retorno.setCep(address.getCep());
        retorno.setEstado(address.getEstado());
        retorno.setEmail(createAddressDto.getEmail());
        return retorno;


    }
}
