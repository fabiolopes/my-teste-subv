package com.requerOnline.core;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Entity
public class GerenciadorConectado {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraLogin;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraLogoff;
	
	@Autowired
	@OneToOne
	private Gerenciador gerenciador;
	
	public GerenciadorConectado() {
		gerenciador = new Gerenciador();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataHoraLogin() {
		return dataHoraLogin;
	}

	public void setDataHoraLogin(Date dataHoraLogin) {
		this.dataHoraLogin = dataHoraLogin;
	}

	public Date getDataHoraLogoff() {
		return dataHoraLogoff;
	}

	public void setDataHoraLogoff(Date dataHoraLogoff) {
		this.dataHoraLogoff = dataHoraLogoff;
	}

	public Gerenciador getGerenciador() {
		return gerenciador;
	}

	public void setGerenciador(Gerenciador gerenciador) {
		this.gerenciador = gerenciador;
	}

}
