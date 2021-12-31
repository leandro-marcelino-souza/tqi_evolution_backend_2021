package com.tqi_evolution_avaliacao.repositories;


import com.tqi_evolution_avaliacao.dto.LoanDto;
import com.tqi_evolution_avaliacao.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


//(exported = false)

@RepositoryRestResource
public interface LoanRepository extends JpaRepository<Loan, Long> {
    //Buscando empretsimo por data
    //formatadando data com @DateTimeFormat(
    //List<Loan> findByDataAtual(@Param("dataatual") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataatual);
    //Loan findByEmail(@Param("email") String email);

}
