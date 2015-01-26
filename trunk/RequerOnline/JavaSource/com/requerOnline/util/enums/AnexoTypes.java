package com.requerOnline.util.enums;

public enum AnexoTypes {

	ENVIO(1), RESPOSTA(2);
	
	private int value;
	
	AnexoTypes(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
