package com.requerOnline.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.requerOnline.util.enums.EstadoTypes;

@Service
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Insira o nome da rua")
	private String rua;
	
	@NotNull(message="Insira o número")
	private String num;
	
	@Column(nullable=true)
	private String complemento;
	
	@NotNull(message="Insira o bairro")
	private String bairro;
	
	@NotNull(message="Insira a cidade")
	private String cidade;
	
	@NotNull(message="Insira o CEP")
	private String cep;
	
	@NotNull(message="Insira o estado")
	private EstadoTypes estado;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public EstadoTypes getEstado() {
		return estado;
	}

	public void setEstado(EstadoTypes estado) {
		this.estado = estado;
	}

}
