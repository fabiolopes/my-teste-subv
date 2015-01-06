package com.requerOnline.core;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Service;

import com.requerOnline.util.enums.PerfilTypes;

@NamedQueries({ 
	@NamedQuery(name = "Gerenciador.logar", query = "SELECT g FROM Gerenciador AS g "
			+ "WHERE g.matricula=:matricula AND g.senha=:senha") 
	})

@Service
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Gerenciador extends Funcionario {

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
