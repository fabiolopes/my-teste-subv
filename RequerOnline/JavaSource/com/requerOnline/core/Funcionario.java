package com.requerOnline.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Service;

@Service
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Funcionario {

	@Id
	@CPF(message = "CPF inválido. Insira um CPF existente.")
	private String cpf;

	@Column(unique = true)
	private String matricula;

	@NotNull(message = "Insira um nome.")
	private String nome;

	@NotNull(message = "Insira uma senha")
	@Length(min = 8, max = 20, message = "Senha deve ter de 8 a 20 caracteres.")
	private String senha;

	@Email(message="Insira um email v�lido.")
	private String email;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
