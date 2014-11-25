package br.com.mylearning.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	private static Log log = LogFactory.getLog(HibernateUtil.class);
	static{
		try {
			log.debug("Iniciando a sessionFactory");
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			log.error("Erro criando sessionFactory");
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
