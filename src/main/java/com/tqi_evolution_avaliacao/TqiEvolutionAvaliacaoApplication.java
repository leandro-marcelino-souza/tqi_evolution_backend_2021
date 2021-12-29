package com.tqi_evolution_avaliacao;

import com.tqi_evolution_avaliacao.entity.Address;
import com.tqi_evolution_avaliacao.entity.Client;
import com.tqi_evolution_avaliacao.repositories.AddressRepository;
import com.tqi_evolution_avaliacao.repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TqiEvolutionAvaliacaoApplication {
	@Autowired
	ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(TqiEvolutionAvaliacaoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			List<Client> clients = clientRepository.findAll();
			clients.forEach(client -> System.out.println(client.getEmail()));
		};
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	};

}

