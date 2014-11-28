package br.com.livraria.service;

import br.com.livraria.serviceImpl.AutorServiceImpl;
import br.com.livraria.serviceImpl.EditoraServiceImpl;

public interface IServiceDelegate {
	
	public EditoraServiceImpl getEditoraService();
	
	public AutorServiceImpl getAutorService();

}
