package br.com.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory factory;
	
	private ConnectionFactory(){
	}
	
	public static EntityManager getManagerFactory(){
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("onelibrary");
		}
		return factory.createEntityManager();
	}
	
	public static void closeEntityManagerFactory(){
		factory.close();
	}
	
}
