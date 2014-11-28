package br.com.livraria.dao;

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
	public Object localizarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Object o) {
		// TODO Auto-generated method stub
		
	}

}
