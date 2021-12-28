package com.tqi_evolution_avaliacao.repositories;

import com.tqi_evolution_avaliacao.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
