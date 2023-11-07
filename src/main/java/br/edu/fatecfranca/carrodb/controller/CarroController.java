package br.edu.fatecfranca.carrodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecfranca.carrodb.model.dto.CarroDto;
import br.edu.fatecfranca.carrodb.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	@Autowired
	CarroService servico;

	@GetMapping
	public List<CarroDto> getCarros(){
		return servico.getCarros();
	}

	@GetMapping("/{id}")
	public CarroDto getCarro (@PathVariable Long id) {
		CarroDto prod = servico.getCarro(id);
		return prod;
	}
	
	@PostMapping
	public CarroDto addCarro(@RequestBody CarroDto carroDto) {
		return servico.addCarro(carroDto);
	}

	@DeleteMapping("/{id}")
	public String removeCarro(@PathVariable Long id) {
		servico.removeCarro(id);
		return "Remoção com sucesso";
	}

	@PutMapping()
	public CarroDto updateCarro(@RequestBody CarroDto carroDto) {
		return servico.updateCarro(carroDto);
	}
}