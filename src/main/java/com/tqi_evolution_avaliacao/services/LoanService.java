package com.tqi_evolution_avaliacao.services;

import com.tqi_evolution_avaliacao.dto.AddressDto;
import com.tqi_evolution_avaliacao.dto.CreateLoanDto;
import com.tqi_evolution_avaliacao.dto.LoanDto;
import com.tqi_evolution_avaliacao.entity.Address;
import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.entity.Loan;
import com.tqi_evolution_avaliacao.repositories.ClientRepository;
import com.tqi_evolution_avaliacao.repositories.LoanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private ModelMapper modelMapper;

    //Pesquisa por ID
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<LoanDto> findById(Long id) {
        Optional<Loan> loans = loanRepository.findById(id);
        return loans.stream().map(x -> new LoanDto(x)).collect(Collectors.toList());
    }
    //pesquisa por CPF
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<LoanDto> findByClientCpf(String cpf) {
        List<Loan> loan =  loanRepository.findByClientCpf(cpf);

        return loan.stream().map(x -> new LoanDto(x)).collect(Collectors.toList());
    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public CreateLoanDto save(CreateLoanDto createLoanDto) {
        Loan loan = new Loan();
        loan.setValor(createLoanDto.getValor());
        loan.setDataPrimeiraParcela(createLoanDto.getDataPrimeiraParcela());
        loan.setParcelas(createLoanDto.getParcelas());
        loan.setDataAtual(createLoanDto.getDataAtual());
        loan.setClient(clientRepository.findByCpf(createLoanDto.getCpf()));

        loan = loanRepository.save(loan);

        CreateLoanDto retorno = new CreateLoanDto();
        retorno.setValor(createLoanDto.getValor());
        retorno.setDataPrimeiraParcela(createLoanDto.getDataPrimeiraParcela());
        retorno.setParcelas(createLoanDto.getParcelas());
        retorno.setDataAtual(createLoanDto.getDataAtual());
        retorno.setCpf(createLoanDto.getCpf());
        return retorno;

    }

}
