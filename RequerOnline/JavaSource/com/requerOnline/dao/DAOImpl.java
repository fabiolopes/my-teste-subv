package com.requerOnline.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class DAOImpl implements IDAO{

	private EntityManager manager;
	
	@Override
	public void inserir(Object o) {
		manager = ConnectionFactory.getManagerFactory();
		manager.getTransaction().begin();
		manager.persist(o);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void atualizar(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object localizar(Object tabela, Object campo, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Object o) {
		// TODO Auto-generated method stub
		
	}

}
