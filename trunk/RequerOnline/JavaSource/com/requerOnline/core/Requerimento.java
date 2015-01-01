package com.requerOnline.core;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Entity
public class Requerimento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Autowired
	@OneToOne
	private Requerente requerente;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraEntrada;
	
	@NotNull(message="Informe o pedido.")
	private String pedido;
	
	@Null
	private String obs;
	
	private String status;
	
	private Date dataHoraResposta;
	
	private String obsResposta;
	
	@Autowired
	@OneToOne
	private Anexo anexoEnvio;
	
	@Autowired
	@OneToOne
	private Anexo anexoResposta;
	
	public Requerimento() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Requerente getRequerente() {
		return requerente;
	}

	public void setRequerente(Requerente requerente) {
		this.requerente = requerente;
	}

	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataHoraResposta() {
		return dataHoraResposta;
	}

	public void setDataHoraResposta(Date dataHoraResposta) {
		this.dataHoraResposta = dataHoraResposta;
	}

	public String getObsResposta() {
		return obsResposta;
	}

	public void setObsResposta(String obsResposta) {
		this.obsResposta = obsResposta;
	}

	public Anexo getAnexoEnvio() {
		return anexoEnvio;
	}

	public void setAnexoEnvio(Anexo anexoEnvio) {
		this.anexoEnvio = anexoEnvio;
	}

	public Anexo getAnexoResposta() {
		return anexoResposta;
	}

	public void setAnexoResposta(Anexo anexoResposta) {
		this.anexoResposta = anexoResposta;
	}

}
