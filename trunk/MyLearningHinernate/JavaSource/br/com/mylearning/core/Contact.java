package br.com.mylearning.core;

import java.io.Serializable;

public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String contactName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
