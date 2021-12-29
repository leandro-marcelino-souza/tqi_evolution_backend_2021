package com.tqi_evolution_avaliacao.repositories;

import com.tqi_evolution_avaliacao.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//exported = false para não disponibilizar a api direto do repositorio
@RepositoryRestResource(exported = false)
public interface ClientRepository extends JpaRepository<Client, Long> {
    //Criando busca por e-mail
    Client findByEmail(String email);
    //Criando o metodo para deletar
}
