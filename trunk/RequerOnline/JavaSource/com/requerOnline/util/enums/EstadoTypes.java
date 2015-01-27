package com.requerOnline.util.enums;

public enum EstadoTypes {
	ACRE("AC"), ALAGOAS("AL"), AMAPA("AP"), 
    AMAZONAS("Amazonas"), BAHIA("BA"), CEARA("CE"), DISTRITO_FEDERAL("DF"), 
    ESPIRITO_SANTO("ES"), GOIAS("GO"), MARANHAO("MA"), MATO_GROSSO("MT"), 
    MATO_GROSSO_DO_SUL("MS"), MINAS_GERAIS("MG"), 
    PARA("PA"), PARAIBA("PB"), PARANA("PR"), PERNAMBUCO("PE"), PIAUI("PI"), 
    RIO_DE_JANEIRO("RJ"), RIO_GRANDE_DO_NORTE("RN"), 
    RIO_GRANDE_DO_SUL("RS"), RONDONIA("RO"), RORAIMA("RR"), 
    SANTA_CATARINA("SC"), SAO_PAULO("SP"), SERGIPE("SE"), TOCANTINS("TO");
	
	private String value;
	
	EstadoTypes(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
