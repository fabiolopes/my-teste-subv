package com.requerOnline.core;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

@Service
@Entity
public class Administrador extends Gerenciador{

	@NotNull(message="Insira um setor.")
	private String setor;
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
