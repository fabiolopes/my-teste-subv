package com.requerOnline.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

@Service
@Embeddable
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Insira o nome da rua")
	private String rua;
	
	@NotEmpty(message="Insira o número")
	private String num;
	
	@Column(nullable=true)
	private String complemento;
	
	@NotEmpty(message="Insira o bairro")
	private String bairro;
	
	@NotEmpty(message="Insira a cidade")
	private String cidade;
	
	@NotEmpty(message="Insira o CEP")
	private String cep;
	
	@NotEmpty(message="Insira o estado")
	private String estado;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
