package com.requerOnline.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import com.requerOnline.core.Administrador;
import com.requerOnline.core.Gerenciador;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.core.Secretario;
import com.requerOnline.daoImpl.GerenciadorDAO;
import com.requerOnline.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public GerenciadorConectado getGerenciadorLogado(Gerenciador gerenciador) {
		Map<String, Object> dados = new HashMap<String, Object>();
		if(gerenciador instanceof Administrador){
			dados.put("tabela", "Administrador");
		}else if(gerenciador instanceof Secretario){
			dados.put("tabela", "Secretario");
		}
		dados.put("campo", "matricula");
		dados.put("valor", gerenciador.getMatricula());
		
		GerenciadorDAO dao = new GerenciadorDAO();
		return dao.logar(dados);
	}



}
