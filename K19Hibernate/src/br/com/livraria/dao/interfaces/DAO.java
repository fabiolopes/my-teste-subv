package br.com.livraria.dao.interfaces;

import java.util.List;

public interface DAO {

	public void inserir(final Object o);
	
	public void atualizar(final Object o);
	
	public List<Object> listar();
	
	public Object localizarPorId(final long id);
	
	public void excluir(final Object o);
}
