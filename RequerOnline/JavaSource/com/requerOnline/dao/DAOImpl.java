package com.requerOnline.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		try {
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	@Override
	public void atualizar(String namedQuery, Map<String, Object> dados) {
		manager = ConnectionFactory.getManagerFactory();
		manager.getTransaction().begin();
		Query query = manager.createNamedQuery(namedQuery);

		for (Entry<String, Object> dado : dados.entrySet()) {
			query.setParameter(dado.getKey(), dado.getValue());
		}

		try {
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	@Override
	public List<Object> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Recebe um namedQuery que será chamado pelo manager, e um mapa, contendo o
	 * nome do atributo e o valor, que será inserido através do setParameter,
	 * por meio do for each
	 */
	@Override
	public Object localizar(String namedQuery, Map<String, Object> dados) {
		manager = ConnectionFactory.getManagerFactory();
		Query query = manager.createNamedQuery(namedQuery);

		for (Entry<String, Object> dado : dados.entrySet()) {
			query.setParameter(dado.getKey(), dado.getValue());
		}

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
