package com.requerOnline.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Funcionario implements Serializable{

	private static final long serialVersionUID = -6678136881633030746L;

	@Id
	@CPF(message = "CPF inválido. Insira um CPF existente.")
	private String cpf;

	@Column(unique = true)
	private String matricula;

	@NotEmpty(message="Insira um nome")
	private String nome;

	@Email(message="Insira um email válido.")
	private String email;
	
	@NotEmpty(message = "Insira uma nacionalidade.")
	private String nacionalidade;

	@NotEmpty
	@Length(min = 5, message = "Insira um RG válido.")
	private String rg;

	@Autowired
	@Embedded
	private Endereco endereco;

	@Pattern(regexp = "^\\(?\\d{2}\\)?[\\s-]?\\d{4}-?\\d{4}$", message="Insira um telefone válido")
	@NotEmpty(message="Insira um telefone de contato.")
	private String telefone;
	
	@NotEmpty(message="Informe o vínculo empregatício.")
	private String vinculo;
	
	@NotEmpty(message="Informe a função.")
	private String funcao;
	
	@NotEmpty(message="Informe a secretaria de lotação.")
	private String secretaria;
	
	@NotEmpty(message="Informe o setor de origem.")
	private String setor;


	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
