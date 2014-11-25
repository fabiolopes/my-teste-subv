package br.com.mylearning.core;

import java.io.Serializable;

public class EmailAndFax extends Contact implements Serializable{

	private static final long serialVersionUID = 1L;

	private String primaryEmail;
	
	private String secondaryEmail;
	
	private String faxNumber;

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
}
