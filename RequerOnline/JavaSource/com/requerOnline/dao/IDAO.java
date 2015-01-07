package com.requerOnline.dao;

import java.util.List;
import java.util.Map;

public interface IDAO {

	public void inserir(final Object o);
	
	public void atualizar(final String namedQuery, final Map<String, Object> dados);
	
	public List<Object> listar();
	
	public Object localizar(final String namedQuery, final Map<String, Object> dados);
	
	public void excluir(final Object o);
}
