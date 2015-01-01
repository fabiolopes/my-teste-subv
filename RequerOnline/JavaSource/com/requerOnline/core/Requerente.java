package com.requerOnline.core;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Entity
public class Requerente extends Funcionario {

	@NotNull(message = "Insira uma nacionalidade.")
	private String nacionalidade;

	@NotNull
	@Length(min = 5, message = "Insira um RG válido.")
	private String rg;

	@Autowired
	@OneToOne
	private Endereco endereco;

	@Pattern(regexp = "^\\(?\\d{2}\\)?[\\s-]?\\d{4}-?\\d{4}$")
	@NotNull(message="Insira um telefone de contato.")
	private String telefone;
	
	@NotNull(message="Informe o vínculo empregatício.")
	private String vinculo;
	
	@NotNull(message="Informe a função.")
	private String funcao;
	
	@NotNull(message="Informe a secretaria de lotação.")
	private String secretaria;
	
	@NotNull(message="Informe o setor de origem.")
	private String setor;

	public Requerente() {
		// TODO Auto-generated constructor stub
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(String secretaria) {
		this.secretaria = secretaria;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
