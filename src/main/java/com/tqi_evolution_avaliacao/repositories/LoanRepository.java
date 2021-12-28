package com.tqi_evolution_avaliacao.repositories;

import com.tqi_evolution_avaliacao.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
