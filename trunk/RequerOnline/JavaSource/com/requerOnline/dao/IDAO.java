package com.requerOnline.dao;

import java.util.List;
import java.util.Map;

public interface IDAO {

	public void inserir(final Object o);
	
	public void atualizar(final Object o);
	
	public List<Object> listar();
	
	public Object localizar(String namedQuery, Map<String, Object> dados);
	
	public void excluir(final Object o);
}
