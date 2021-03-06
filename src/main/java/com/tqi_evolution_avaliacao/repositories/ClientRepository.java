package com.tqi_evolution_avaliacao.repositories;

import com.tqi_evolution_avaliacao.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

//exported = false para não disponibilizar a api direto do repositorio
@RepositoryRestResource(exported = false)
public interface ClientRepository extends JpaRepository<Client, Long> {
    //Criando busca por e-mail
    //Client findByEmail(String email);
    //Criando o metodo para deletar

    //Criando busca por e-mail
    Client findByCpf(String cpf);


    Optional<Client> findByEmail(String email);

    void deleteByCpf(String cpf);
}
