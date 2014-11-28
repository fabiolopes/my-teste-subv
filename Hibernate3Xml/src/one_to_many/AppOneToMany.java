package one_to_many;

import one_to_one.Documento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class AppOneToMany {
	
	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) {
		Categoria cat = new Categoria();
		cat.setNome("Celulares");
		
		Produto prod = new Produto();
		prod.setNome("Sony Erikson Xperia L");
		prod.setPreco(399.90);
		cat.addProduto(prod);
		
		Produto prod2 = new Produto();
		prod2.setNome("LG KP 23");
		prod2.setPreco(99.90);
		cat.addProduto(prod2);
		
		Produto prod3 = new Produto();
		prod3.setNome("Motorola Moto g");
		prod3.setPreco(1509.09);
		cat.addProduto(prod3);
		
		insertCategoria(cat);
	}
	
	public static void insertCategoria(Categoria c){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			int catId = (Integer) session.save(c);
			tx.commit();
			System.out.println("Categoria inserida com sucesso. Id = "+catId);
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public static void insertProduto(Produto p){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			int prodId = (Integer) session.save(p);
			tx.commit();
			System.out.println("Produto inserido com sucesso. Id = "+prodId);
		} catch (Exception e) {
			tx.rollback();
		}

	}
}
