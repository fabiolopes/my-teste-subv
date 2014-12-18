package br.com.sgst.enums;

public enum UsuarioTypes {

	ADM(1), USER(2);
	
	private int value;
	
	private UsuarioTypes(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
