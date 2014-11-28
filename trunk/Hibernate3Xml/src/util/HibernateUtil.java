package util;

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
		} catch (Throwable e) {
			log.error("Erro ao criar a sessionFactory");
			throw new ExceptionInInitializerError(e);
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
