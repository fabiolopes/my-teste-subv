package com.requerOnline.daoImpl;

import java.util.Date;
import java.util.Map;

import com.requerOnline.applicationContext.SpringBeans;
import com.requerOnline.core.Gerenciador;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.dao.DAOImpl;

public class GerenciadorDAO extends DAOImpl {

	public GerenciadorConectado logar(Map<String, Object> dados) {
		String alias = ((String) dados.get("tabela")).toLowerCase();
		//Query para pesquisar gerenciador com matrícula e senha iguais
		/*String jpql = "SELECT " + alias + " from " + dados.get("tabela")
				+ " as " + alias + " where " + alias + "."
				+ dados.get("campo1") + "=" + ""+dados.get("valor1");*/
		
		Gerenciador gerenciador = (Gerenciador) localizar(dados.get("tabela"), dados.get("campo1"), dados.get("valor1"));
		if (gerenciador != null) {
			GerenciadorConectado gerenciadorConectado = SpringBeans
					.getBeanGerenciadorConectado();
			gerenciadorConectado.setDataHoraLogin(new Date());
			gerenciadorConectado.setGerenciador(gerenciador);
			inserir(gerenciadorConectado);
			return gerenciadorConectado;
		} else {
			return null;
		}
	}
}
