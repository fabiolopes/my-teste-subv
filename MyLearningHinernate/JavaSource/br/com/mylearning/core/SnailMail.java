package br.com.mylearning.core;

import java.io.Serializable;

public class SnailMail extends Contact implements Serializable{

	private static final long serialVersionUID = 1L;

	private String details1;
	
	private String city;
	
	private String state;
	
	private long zipCode;
	
	private String country;

	public String getDetails1() {
		return details1;
	}

	public void setDetails1(String details1) {
		this.details1 = details1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
