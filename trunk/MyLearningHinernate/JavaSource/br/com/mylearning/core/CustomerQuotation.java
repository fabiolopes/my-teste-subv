package br.com.mylearning.core;

import java.util.Date;

public class CustomerQuotation {
	
	private Customer customer;
	
	private Long id;
	
	private String status;
	
	private String quoteDesc;
	
	private Date quoteDate;
	
	private Date quoteValidity;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuoteDesc() {
		return quoteDesc;
	}

	public void setQuoteDesc(String quoteDesc) {
		this.quoteDesc = quoteDesc;
	}

	public Date getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(Date quoteDate) {
		this.quoteDate = quoteDate;
	}

	public Date getQuoteValidity() {
		return quoteValidity;
	}

	public void setQuoteValidity(Date quoteValidity) {
		this.quoteValidity = quoteValidity;
	}
	
}
