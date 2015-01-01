package com.requerOnline.daoImpl;

import java.util.Date;
import java.util.Map;

import com.requerOnline.applicationContext.SpringBeans;
import com.requerOnline.core.Gerenciador;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.dao.DAOImpl;

public class GerenciadorDAO extends DAOImpl {

	public GerenciadorConectado logar(Map<String, Object> dados) {
		Gerenciador gerenciador = (Gerenciador) localizar(dados.get("tabela"),
				dados.get("campo"), dados.get("valor"));
		if(gerenciador != null){
			GerenciadorConectado gerenciadorConectado = SpringBeans.getBeanGerenciadorConectado();
			gerenciadorConectado.setDataHoraLogin(new Date());
			gerenciadorConectado.setGerenciador(gerenciador);
			inserir(gerenciadorConectado);
			return gerenciadorConectado;
		}else{
			return null;
		}
	}
}