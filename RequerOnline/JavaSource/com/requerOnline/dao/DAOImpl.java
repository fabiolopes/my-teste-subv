package com.requerOnline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOImpl implements IDAO {

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
		String alias = ((String) tabela).toLowerCase();
		manager = ConnectionFactory.getManagerFactory();
		Query query = manager.createQuery("SELECT " + alias + " from " + tabela
				+ " as " + alias);
		if (query.getFirstResult() != 0) {
			return query.getSingleResult();
		} else {
			return null;
		}
	}

	@Override
	public void excluir(Object o) {
		// TODO Auto-generated method stub

	}

}
