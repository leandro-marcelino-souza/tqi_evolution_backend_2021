package com.tqi_evolution_avaliacao.services;

import com.tqi_evolution_avaliacao.dto.CreateAddressDto;
import com.tqi_evolution_avaliacao.dto.CreateLoanDto;
import com.tqi_evolution_avaliacao.dto.LoanDto;
import com.tqi_evolution_avaliacao.entity.Address;
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
    ClientRepository clientRepository;
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private ModelMapper modelMapper;

   /* @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<LoanDto> findByEmail(String email) {
        List<Loan> loans = (List<Loan>) loanRepository.findByEmail(email);

        return loans.stream().map(x -> new LoanDto(x)).collect(Collectors.toList());
    }
*/
    @Transactional(propagation= Propagation.REQUIRED, readOnly=false)
    public CreateLoanDto save(CreateLoanDto createLoanDto) {
        Loan loan = new Loan();
        loan.setValor(createLoanDto.getValor());
        loan.setDataPrimeiraParcela(createLoanDto.getDataPrimeiraParcela());
        loan.setParcelas(createLoanDto.getParcelas());
        loan.setDataAtual(createLoanDto.getDataAtual());
        loan.setClient(clientRepository.findByEmail(createLoanDto.getEmail()));

        loan = loanRepository.save(loan);

        CreateLoanDto retorno = new CreateLoanDto();
        retorno.setValor(createLoanDto.getValor());
        retorno.setDataPrimeiraParcela(createLoanDto.getDataPrimeiraParcela());
        retorno.setParcelas(createLoanDto.getParcelas());
        retorno.setDataAtual(createLoanDto.getDataAtual());
        retorno.setEmail(createLoanDto.getEmail());
        return retorno;


    }

}
