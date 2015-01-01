package com.requerOnline.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Classe para manipular arquivo property
public class ArquivoProperty {

	private static Properties property;

	//este método retorna o property dos labels
	public static Properties getPropriedade() throws IOException{
		if(property == null){
			FileInputStream input = new FileInputStream("/JavaSource/label_pt_br.properties");
			property = new Properties();
			property.load(input);
		}
		
		return property;
	}

}
