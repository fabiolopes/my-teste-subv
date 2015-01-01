package com.requerOnline.core;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.stereotype.Service;

import com.requerOnline.util.enums.PerfilTypes;

@Service
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Gerenciador extends Funcionario{

	private PerfilTypes perfil;
	
	public Gerenciador() {
		// TODO Auto-generated constructor stub
	}

	public PerfilTypes getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilTypes perfil) {
		this.perfil = perfil;
	}

}
