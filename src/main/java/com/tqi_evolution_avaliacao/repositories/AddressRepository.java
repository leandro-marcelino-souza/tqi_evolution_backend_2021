package com.tqi_evolution_avaliacao.repositories;

import com.tqi_evolution_avaliacao.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByCep(@Param("cep") String cep);
}
