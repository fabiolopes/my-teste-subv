package br.com.livraria.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.livraria.dao.interfaces.DAO;

public class DAOImpl implements DAO{

	private EntityManager manager;
	
	@Override
	public void inserir(Object o) {
		manager = ConnectionFactory.getManagerFactory();
		manager.getTransaction().begin();
		manager.persist(o);
		
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
