package com.requerOnline.core;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

@Service
@Entity
public class Secretario extends Gerenciador{

	@NotNull(message="Insira uma secretaria.")
	private String secretaria;
	
	public Secretario() {
		// TODO Auto-generated constructor stub
	}

	public String getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(String secretaria) {
		this.secretaria = secretaria;
	}

}
