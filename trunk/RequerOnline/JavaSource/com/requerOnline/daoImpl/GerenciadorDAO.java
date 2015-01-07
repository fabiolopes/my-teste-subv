package com.requerOnline.daoImpl;

import java.util.Date;
import java.util.Map;

import com.requerOnline.applicationContext.SpringBeans;
import com.requerOnline.core.Gerenciador;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.dao.DAOImpl;

public class GerenciadorDAO extends DAOImpl {

	public GerenciadorConectado logar(Map<String, Object> dados) {
		Gerenciador gerenciador = (Gerenciador) localizar("Gerenciador.logar",
				dados);
		if (gerenciador != null) {
			return registrarGerenciadorConectado(gerenciador);
		} else {
			return null;
		}
	}

	/*Registrar o login efetuado pelo gerenciador*/
	private GerenciadorConectado registrarGerenciadorConectado(
			Gerenciador gerenciador) {
		GerenciadorConectado gerenciadorConectado = SpringBeans
				.getBeanGerenciadorConectado();
		gerenciadorConectado.setDataHoraLogin(new Date());
		gerenciadorConectado.setGerenciador(gerenciador);
		inserir(gerenciadorConectado);
		return gerenciadorConectado;
	}
	
	public void desconectarGerenciadorLogado(Map<String, Object> dados){
		atualizar("GerenciadorConectado.RegistrarLogoff", dados);
	}
}
