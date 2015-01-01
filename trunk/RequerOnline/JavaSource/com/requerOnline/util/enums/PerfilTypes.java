package com.requerOnline.util.enums;

public enum PerfilTypes {

	ADMINISTRADOR(1), SECRETARIO(2);
	
	private int value;
	
	private PerfilTypes(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
