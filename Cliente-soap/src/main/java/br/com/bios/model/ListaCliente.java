package br.com.bios.model;

import java.util.ArrayList;

public class ListaCliente {
	private String responseCode;
	private ArrayList<Cliente> clientes;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
