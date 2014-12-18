package br.com.sgst.core;

import br.com.sgst.enums.UsuarioTypes;

public class Usuario {

	private int id;
	
	private String nome;
	
	private String cpf;
	
	private String login;
	
	private String senha;
	
	private UsuarioTypes tipoUsuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioTypes getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(UsuarioTypes tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
