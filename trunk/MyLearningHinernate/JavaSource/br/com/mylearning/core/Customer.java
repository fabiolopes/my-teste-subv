package br.com.mylearning.core;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String phone;
	
	private String type;
	
	private Date startBusinessDate;
	
	private Name customerName;
	
	private Set<CustomerQuotation> quotes = new HashSet<CustomerQuotation>();

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String phone, String type, Date startBusinessDate) {
		super();
		this.phone = phone;
		this.type = type;
		this.startBusinessDate = startBusinessDate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartBusinessDate() {
		return startBusinessDate;
	}

	public void setStartBusinessDate(Date startBusinessDate) {
		this.startBusinessDate = startBusinessDate;
	}

	public Name getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}

	public Set<CustomerQuotation> getQuotes() {
		return quotes;
	}

	public void setQuotes(Set<CustomerQuotation> quotes) {
		this.quotes = quotes;
	}
	
	private void addQuotes(CustomerQuotation quote){
		this.getQuotes().add(quote);
	}

}
