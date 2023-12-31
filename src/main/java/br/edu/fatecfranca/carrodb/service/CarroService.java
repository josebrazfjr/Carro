package br.edu.fatecfranca.carrodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.fatecfranca.carrodb.model.dto.CarroDto;
import br.edu.fatecfranca.carrodb.model.entity.Carro;
import br.edu.fatecfranca.carrodb.repository.CarroRepository;

@Service
public class CarroService {
	@Autowired
	CarroRepository injecao;
	
	@GetMapping
	public List<CarroDto> getCarros(){
		List<Carro> carros = injecao.findAll();
		return converteListaCarrostoListaDtos(carros);
	}
	
	@GetMapping("/{id}")
	public CarroDto getCarro (@PathVariable Long id) {
		Optional<Carro> optional = injecao.findById(id);
		if (optional.isPresent()) {
			return converteCarroToDto(optional.get());
		}
		return null;
	}
	
	@PostMapping
	public CarroDto addCarro(@RequestBody CarroDto carroDto) {
		Carro carro = converteDtoToCarro(carroDto);
		return converteCarroToDto(injecao.save(carro));
	}
	
	@DeleteMapping("/{id}")
	public String removeCarro(@PathVariable Long id) {
		injecao.deleteById(id);
		return "Remoção com sucesso";
	}
	
	@PutMapping()
	public CarroDto updateCarro(@RequestBody CarroDto carroDto) {
		Carro carro = converteDtoToCarro(carroDto);
		return converteCarroToDto(injecao.save(carro));
	}
	
	public Carro converteDtoToCarro(CarroDto dto) {
		Carro carro = new Carro();
		carro.setMarca(dto.getMarca());
		carro.setId(dto.getId());
		carro.setModelo(dto.getModelo());
		carro.setCor(dto.getCor());
		carro.setAno(dto.getAno());
		return carro;
	}
	
	public CarroDto converteCarroToDto(Carro carro) {
		CarroDto dto = new CarroDto();
		dto.setModelo(carro.getModelo());
		dto.setId(carro.getId());
		dto.setMarca(carro.getMarca());
		dto.setCor(carro.getCor());
		dto.setAno(carro.getAno());
		return dto;
	}
	
	public List<CarroDto> converteListaCarrostoListaDtos(List<Carro> carros){
		List<CarroDto> listaDto = new ArrayList<CarroDto>();
		for(int i=0;i<carros.size();i++) {
			listaDto.add(converteCarroToDto(carros.get(i)));
		}
		return listaDto;
	}

}
