package one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class AppOneToOne {

	static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Fabio");
		pessoa.setIdade(29);
		
		Documento doc = new Documento();
		doc.setRg("131115792");
		doc.setCpf("112.545.454-78");
		pessoa.setDocumento(doc);
		insertPessoa(pessoa);
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		Pessoa p = (Pessoa) session.get(Pessoa.class, 1);
		tx.commit();
	}
	
	public static void insertDocumento(Documento d){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			int docId = (Integer) session.save(d);
			tx.commit();
			System.out.println("Documento inserido com sucesso. Id = "+docId);
		} catch (Exception e) {
			tx.rollback();
		}

	}

	public static void insertPessoa(Pessoa p) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			int pessoaId = (Integer) session.save(p);
			tx.commit();
			System.out.println("Pessoa inserida com sucesso. Id = "+pessoaId);
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
