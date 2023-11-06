package br.edu.fatecfranca.carrodb.model.dto;


public class CarroDto {

	private Long id;
	private String modelo;
	private String marca;
	private String cor;
	private int ano;
	
	public CarroDto() {
		
	}
	public CarroDto(Long id, String modelo, String marca, String cor, int ano) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.cor = cor;
		this.ano = ano;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

}