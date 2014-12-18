package br.com.sgst.core;

import java.util.Date;

public class Treinamento {

	private int id;
	
	private Date data;
	
	private Curso curso;
	
	private Empresa empresa;
	
	private boolean treinamentoRealizado;
	
	private Date dataCadastro;
	
	private Usuario usuarioCadastrador;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isTreinamentoRealizado() {
		return treinamentoRealizado;
	}

	public void setTreinamentoRealizado(boolean treinamentoRealizado) {
		this.treinamentoRealizado = treinamentoRealizado;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getUsuarioCadastrador() {
		return usuarioCadastrador;
	}

	public void setUsuarioCadastrador(Usuario usuarioCadastrador) {
		this.usuarioCadastrador = usuarioCadastrador;
	}
	
}
