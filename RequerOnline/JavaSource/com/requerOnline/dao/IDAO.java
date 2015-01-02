package com.requerOnline.dao;

import java.util.List;

public interface IDAO {

	public void inserir(final Object o);
	
	public void atualizar(final Object o);
	
	public List<Object> listar();
	
	public Object localizar(Object tabela, Object campo1, Object valor1);
	
	public void excluir(final Object o);
}
