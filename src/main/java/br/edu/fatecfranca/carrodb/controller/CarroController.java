package br.edu.fatecfranca.carrodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecfranca.carrodb.model.entity.Carro;
import br.edu.fatecfranca.carrodb.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	@Autowired
	CarroService servico;

	@GetMapping
	public List<Carro> getCarros(){
		return servico.getCarros();
	}

	@GetMapping("/{id}")
	public Optional <Carro> getCarro (@PathVariable Long id) {
		Optional<Carro> prod = servico.getCarro(id);
		return prod;
	}
	
	@PostMapping
	public Carro addCarro(@RequestBody Carro carro) {
		return servico.addCarro(carro);
	}

	@DeleteMapping("/{id}")
	public String removeCarro(@PathVariable Long id) {
		servico.removeCarro(id);
		return "Remoção com sucesso";
	}

	@PutMapping()
	public Carro updateCarro(@RequestBody Carro carro) {
		return servico.updateCarro(carro);
	}
}