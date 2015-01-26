package com.requerOnline.util.enums;

public enum VinculoTypes {
	
	EFETIVO("Efetivo"), CONTRATADO("Contratado"), COMISSIONADO("Comissionado"), PRESTADORSERVICO("Prestador de serviço"), OUTRO("Outros");
	
	private String value;

	VinculoTypes(final String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}
