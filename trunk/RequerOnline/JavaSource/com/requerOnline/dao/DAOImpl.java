package com.requerOnline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	public Object localizar(String jpql) {
		manager = ConnectionFactory.getManagerFactory();
		Query query = manager.createQuery(jpql);
		try {
			return query.getSingleResult();
		} catch (NoResultException no) {
			return null;
		}
	}

	@Override
	public void excluir(Object o) {
		// TODO Auto-generated method stub

	}

}
