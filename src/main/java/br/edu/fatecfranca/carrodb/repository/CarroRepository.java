package br.edu.fatecfranca.carrodb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecfranca.carrodb.model.entity.Carro;

public interface CarroRepository
	extends JpaRepository<Carro, Long>{

}