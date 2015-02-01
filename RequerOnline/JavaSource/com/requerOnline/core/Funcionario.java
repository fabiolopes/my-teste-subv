package com.requerOnline.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
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

}
