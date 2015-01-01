package com.requerOnline.util.enums;

public enum DocumentoTypes {

	RAR("rar"), ZIP("zip"), DOCX("docx"), ODT("odt"), PDF("pdf"), XLSX("xlsx");

	private String value;

	DocumentoTypes(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
