package br.com.mylearning.app;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.mylearning.core.Customer;
import br.com.mylearning.core.EmailAndFax;
import br.com.mylearning.core.Name;
import br.com.mylearning.core.SnailMail;
import br.com.mylearning.util.HibernateUtil;

public class OrderManagement {
	private static Log log = LogFactory.getLog(OrderManagement.class);
	SessionFactory sessionFactory;
	static long customerId = 0;

	public static void main(String[] args) throws Exception {
		OrderManagement app = new OrderManagement();
		app.sessionFactory = HibernateUtil.getSessionFactory();
		customerId = app.persistenceObject();
		Thread.sleep(6000);
		app.detectObjectState();
		System.out.println("Customer id: " + customerId);
		app.createContact();
		app.sessionFactory.close();
	}

	public long persistenceObject() throws Exception {
		log.info("Criando persistência de objetos");
		long customId = 0;
		Customer shortTermCustomer = createCustomer("J", "Jones", "Smith");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			customId = (Long) session.save(shortTermCustomer);
			tx.commit();
			return customId;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}
	
	public void modifyObject() throws Exception{
		log.info("Modificando um objeto persistido");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Customer customer = (Customer)session.load(Customer.class, customerId);
			customer.setPhone("9544-1224");
			customer.getCustomerName().setFirstName("Indianna");
			session.flush();
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}
	
	public void deleteObject() throws Exception{
		log.info("Deletando um objeto");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Customer customer = (Customer) session.load(Customer.class, customerId);
			session.delete(customer);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}
	

	public Customer createCustomer(String initial, String firstName, String lastName) {
		log.info("creating new customer");
		Customer shortTermCustomer = new Customer();
		Name customerName = new Name();
		customerName.setInitial(initial);
		customerName.setFirstName(firstName);
		customerName.setLastName(lastName);
		shortTermCustomer.setCustomerName(customerName);
		shortTermCustomer.setType("SHORT_TERM");
		shortTermCustomer.setPhone("334-555-2323");
		Calendar c = Calendar.getInstance();
		c.set(2014, Calendar.NOVEMBER, 24);
		Date data = c.getTime();
		shortTermCustomer.setStartBusinessDate(data);
		return shortTermCustomer;

	}
	
	public void detectObjectState() throws Exception{
		log.info("Detectando estado do objeto");
		Session firstSession = null;
		Session secondSession = null;
		Transaction tx = null;
		
		try {
			firstSession = sessionFactory.openSession();
			tx = firstSession.beginTransaction();
			Customer loadObject = (Customer) firstSession.get(Customer.class, customerId);
			tx.commit();
			firstSession.close();
			loadObject.setType("ADHOC");
			Customer newCustomer = createCustomer("K", "Kim", "Rogers");
			secondSession = sessionFactory.openSession();
			tx = secondSession.beginTransaction();
			secondSession.saveOrUpdate(loadObject);
			secondSession.saveOrUpdate(newCustomer);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			if(firstSession.isOpen()){
				firstSession.close();
			}
			if(secondSession.isOpen()){
				secondSession.close();
			}
		}
	}
	
	public void createContact() throws Exception{
		log.info("criando contato");
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			EmailAndFax econtact = new EmailAndFax();
			econtact.setContactName("Willian");
			econtact.setPrimaryEmail("willian@email.com");
			econtact.setSecondaryEmail("will_2@email.com");
			econtact.setFaxNumber("121-541-245");
			
			SnailMail postalAddress = new SnailMail();
			postalAddress.setContactName("Willian");
			postalAddress.setDetails1("1278 Shore road");
			postalAddress.setCity("North Atlantic");
			postalAddress.setState("CA");
			postalAddress.setCountry("USA");
			postalAddress.setZipCode(1245212);
			
			tx = session.beginTransaction();
			long emailId = (Long) session.save(econtact);
			long postalId = (Long) session.save(postalAddress);
			tx.commit();
			
			tx = session.beginTransaction();
			EmailAndFax emailDetails = (EmailAndFax) session.load(EmailAndFax.class, emailId);
			System.out.println("Endereço de email: "+emailDetails.getPrimaryEmail());
			SnailMail postalDetails = (SnailMail) session.load(SnailMail.class, postalId);
			System.out.println("Endereço postal: "+postalDetails.getCity());
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
	}
}
